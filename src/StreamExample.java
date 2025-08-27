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



        //Stateful and Stateless Intermediate Operations
        /*
        1. Stateless Operations: Fast, parallel friendly
            - Each element is processed independently, without depending on other elements.
            - Processing one element doesn’t require knowledge of previous or future elements.

        Examples:
            map()
            filter()
            flatMap()
            peek()
        */
        List<String> player = Arrays.asList("Rahul", "Rohit", "Virat");
        player.stream()
                .filter(n -> n.startsWith("R"))   // independent check → stateless
                .map(String::toUpperCase)         // independent transform → stateless
                .forEach(System.out::println);


        /*
        2. Stateful Operations: May need buffering, slower
            - Require state/knowledge of other elements in the stream to process correctly.
            - May need to examine the entire stream (or at least more than one element) before producing output.

        Examples:
            sorted()
            distinct()
            limit()
            skip()
        */

        List<Integer> vals = Arrays.asList(5, 2, 7, 2, 9);
        vals.stream()
                .distinct()       // must remember seen elements → stateful
                .sorted()         // must look at whole list to order → stateful
                .limit(3)         // needs element count tracking → stateful
                .forEach(System.out::println);

    }
}
