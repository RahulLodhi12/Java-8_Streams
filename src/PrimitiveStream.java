import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {
    /*
    In Java 8, apart from the regular Stream<T>, we also have specialized streams for primitives:
        IntStream → stream of int values
        LongStream → stream of long values
        DoubleStream → stream of double values
    These are called primitive streams.

    Reason: A normal Stream<Integer> uses Integer objects,
    which means autoboxing/unboxing happens between int ↔ Integer.
    Primitive streams avoid this overhead and give performance benefits for numeric operations.
    */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(nums);
        Stream<Integer> boxed = Arrays.stream(nums).boxed();//boxed() -> convert to Wrapper Class


        List<Integer> list = IntStream.range(1, 9).boxed().toList();
        System.out.println(list);

        IntStream.of(11,22,33);

        DoubleStream doubles = new Random().doubles(5);
        List<Double> doubleList = doubles.boxed().toList();
        System.out.println(doubleList);

        IntStream ints = new Random().ints(5);
//        List<Integer> integerList = ints.boxed().toList();
//        System.out.println(integerList);
//        System.out.println(ints.sum());
//        System.out.println(ints.min());
//        System.out.println(ints.max());
//        System.out.println(ints.average());
        IntSummaryStatistics intSummaryStatistics = ints.summaryStatistics();
        System.out.println(intSummaryStatistics.getCount());

        List<Double> toList = intStream.mapToDouble(x -> (double) x + 0.999).boxed().toList();
        System.out.println(toList);

    }
}
