import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    /*
    List of Terminal Operations:
    1. forEach(Consumer) → perform an action on each element
        stream.forEach(System.out::println);

    2. forEachOrdered(Consumer) → same as forEach but keeps encounter order (in parallel streams)
        stream.forEachOrdered(System.out::println);

    3. toArray() → collect elements into an array
        Object[] arr = stream.toArray();

    4. reduce(...) → reduce to a single value
        int sum = numbers.stream().reduce(0, Integer::sum);

    5. collect(Collector) → collect into collection/map
        List<String> list = stream.collect(Collectors.toList());

    6. min(Comparator) → smallest element
        Optional<Integer> min = numbers.stream().min(Integer::compare);

    7. max(Comparator) → largest element
        Optional<Integer> max = numbers.stream().max(Integer::compare);

    8. count() → count elements
        long total = stream.count();

    9. anyMatch(Predicate) → true if any element matches
        boolean hasR = names.stream().anyMatch(n -> n.startsWith("R"));

    10. allMatch(Predicate) → true if all elements match
        boolean allR = names.stream().allMatch(n -> n.startsWith("R"));

    11. noneMatch(Predicate) → true if no element matches
        boolean noneX = names.stream().noneMatch(n -> n.startsWith("X"));

    12. findFirst() → get first element (if any)
        Optional<String> first = names.stream().findFirst();

    13. findAny() → get any element (useful in parallel streams)
        Optional<String> any = names.stream().findAny();
    */
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(11,22,33,44,55,66,77);

        //1. collect
        List<Integer> collect = list.stream().skip(1).collect(Collectors.toList());
        List<Integer> collect1 = list.stream().skip(1).toList();
        System.out.println(collect);
        System.out.println(collect1);

        //2. forEach -> Consumer -> void accept(T t)
        list.stream().forEach(x -> System.out.print(x+" "));
        System.out.println();

        //3. reduce -> combines elements to product a single result
        //reduce -> BinaryOperator<T,T,T> -> BiFunction<T,T,T> ->  T apply(T t, T t)
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        //4. count
        long count = list.stream().count();
        System.out.println(count);

        //5. anyMatch, allMatch, noneMatch -> Predicate -> boolean test(T t)
        boolean anyMatch = list.stream().anyMatch(x -> x % 7 == 0);
        System.out.println(anyMatch);

        boolean allMatch = list.stream().allMatch(x -> x > 11);
        System.out.println(allMatch);

        boolean noneMatch = list.stream().noneMatch(x -> x > 110);
        System.out.println(noneMatch);

        //6. findFirst, findAny
        Optional<Integer> findFirst = list.stream().findFirst();
        System.out.println(findFirst.get());

        Optional<Integer> findAny = list.stream().findAny();
        System.out.println(findAny.get()); //any random number from stream

        //7. toArray
        Object[] array = Stream.of(11, 22, 33).toArray();
        System.out.println(Arrays.stream(array).toList());

        //8. max/min
        Optional<Integer> max = Stream.of(11, 77, 33, 44).max((a,b)->a-b);
        System.out.println(max.get());

        Optional<Integer> min = Stream.of(33, 44, 22, 77).min(Comparator.naturalOrder());
        System.out.println(min.get());

        //9. forEachOrdered -> forEach() does not guarantee order when using a parallel stream, but forEachOrdered() does.
        List<Integer> nums = Arrays.asList(5, 6, 7, 8, 9);
        System.out.println("forEach with Parallel-Stream:");
        nums.parallelStream().forEach(x-> System.out.print(x+" "));
        System.out.println();

        System.out.println("forEachOrdered with Parallel-Stream:");
        nums.parallelStream().forEachOrdered(x-> System.out.print(x+" "));
        System.out.println();
    }
}
