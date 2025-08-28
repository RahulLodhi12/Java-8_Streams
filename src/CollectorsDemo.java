import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    //Collectors is a utility class (in java.util.stream.Collectors)
    //that provides various ready-made collectors
    public static void main(String[] args) {
        //1. Collecting to List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Bob");
        List<String> collect = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(collect);

        //2. Collecting to Set
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 2, 3);
        Set<Integer> collect1 = nums.stream().collect(Collectors.toSet());
        System.out.println(collect1);

        //3. Collecting to a Specific Collection
        HashSet<String> collect2 = names.stream().collect(Collectors.toCollection(() -> new HashSet<>()));
        System.out.println(collect2);

        //4. Joining String
        String concatedString = names.stream().map(String::toUpperCase).collect(Collectors.joining("$ "));
        System.out.println(concatedString);

        // 5. Summarizing Data
        // Generates statistical summary (count, sum, min, average, max)
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: "+stats.getCount());
        System.out.println("Max: "+stats.getMax());
        System.out.println("Min: "+stats.getMin());
        System.out.println("Avg: "+stats.getAverage());
        System.out.println("Sum: "+stats.getSum());

        //6. Calculating Average
        Double avg = list.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println(avg);

        //7. Counting Element
        Long count = list.stream().collect(Collectors.counting());
        System.out.println(count);

        //8. Grouping Element
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "collections");
        System.out.println(words.stream().collect(Collectors.groupingBy(word->word.length())));
        System.out.println(words.stream().collect(Collectors.groupingBy(word->word.length(),Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(word->word.length(),Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(w -> w.length(), () -> new TreeMap<>(), Collectors.counting()));
        System.out.println(treeMap);
    }
}
