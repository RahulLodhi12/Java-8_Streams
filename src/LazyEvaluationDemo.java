import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Stream<String> stringStream = names.stream().filter(n -> {
            System.out.println("Filtering.." + n);
            return n.length() > 3;
        }); //it will not execute until a Terminal operation is invoked.

        System.out.println("Before Terminal Operation");

        List<String> collect = stringStream.collect(Collectors.toList()); //Terminal operation invoked here.

        System.out.println(collect);
    }
}
