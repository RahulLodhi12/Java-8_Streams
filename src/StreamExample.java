import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args){
        //1. Names with length > 3
        List<String> names = Arrays.asList("Rahul", "Ram", "Mohit", "Poonia");
        List<String> res = names.stream().filter(n -> n.length() > 3).toList();
        System.out.println(res);

        //2. Squaring and sorting
        List<Integer> nums = Arrays.asList(5, 2, 3, 7, 4);
        List<Integer> res1 = nums.stream().map(x -> x * x).sorted().toList();
        System.out.println(res1);

        //3. Summing values
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = values.stream().reduce((x, y) -> x + y);
        System.out.println(sum.get());

        //4. Counting Occurrence of Character
        String str = "Hello World"; //count occurrence of character "l"
        long count = str.chars().filter(ch -> ch=='l').count(); //chars() convert to stream
        System.out.println(count);

    }
}
