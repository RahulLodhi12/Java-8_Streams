import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        //Example 1: Collecting Names by Length
        List<String> names = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(w -> w.length()));
        System.out.println(collect);

        //Example 2: Counting Word Occurrences
        String sentence = "hello world hello java world";
        Map<String, Long> collect1 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(collect1);

        //Example 3: Partitioning Even and Odd Numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect2 = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect2);

        //Example 4: Summing Values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        Integer sum1 = items.values().stream().reduce((x, y) -> x + y).get();
        System.out.println(sum1);
        Integer sum2 = items.values().stream().collect(Collectors.summingInt(v -> v));
        System.out.println(sum2);

        //Example 5: Creating a Map from Stream Elements -> Map<fruitName,fruitLength>
        List<String> fruit = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> map = fruit.stream().collect(Collectors.toMap(f -> f.toUpperCase(), f -> f.length()));
        System.out.println(map);

        //Example 6: Creating a Map like this Map<fruit,count of that fruit>
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> mapCount = fruits.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
        System.out.println(mapCount);

    }
}
