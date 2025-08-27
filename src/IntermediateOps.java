import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    //Intermediate operations transform a stream into another stream.
    //They are lazy, meaning they don't execute until a Terminal operation is invoked.

    /*
    List of Intermediate Operations:
    1. filter(Predicate) → filter elements by condition
        stream.filter(n -> n > 10);

    2. map(Function) → transform each element
        stream.map(String::toUpperCase);

    3. mapToInt / mapToLong / mapToDouble → primitive specialization
        stream.mapToInt(String::length);

    4. flatMap(Function) → flatten nested streams
        stream.flatMap(list -> list.stream());

    5. distinct() → remove duplicates (based on equals())
        stream.distinct();

    6. sorted() → sort elements (natural order)
        stream.sorted();

    7. sorted(Comparator) → custom sort
        stream.sorted(Comparator.reverseOrder());

    8. peek(Consumer) → perform action on each element (mainly for debugging)
        stream.peek(System.out::println);

    9. limit(long n) → keep only first n elements
        stream.limit(5);

    10. skip(long n) → skip first n elements
        stream.skip(2);


     */
    public static void main(String[] args){
        List<String> list = Arrays.asList("Akshit","Ram","Shayam","Ghanshyam","Shayam");

        //1. filter -> Predicate -> boolean test(T t)
        long count = list.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        //2. map -> Function -> R apply(T t)
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        //3. sorted
        List<String> sortedStr = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedStr);
        List<String> sortedStrByComparator = list.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
        System.out.println(sortedStrByComparator);

        //4. distinct
        long count1 = list.stream().filter(s -> s.startsWith("S")).distinct().count();
        System.out.println(count1);

        //5. limit
        List<Integer> collect1 = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList()); //count=100
        System.out.println(collect1);

        //6. skip
        List<Integer> collect2 = Stream.iterate(1, x -> x + 1).skip(10).limit(100).collect(Collectors.toList()); //count=100
        //skip no. from 1 to 10, then starts from 11 till 100 limit reach i.e. 110 number
        System.out.println(collect2);
    }
}
