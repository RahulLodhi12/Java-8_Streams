import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    //What is Stream ?
    //A sequence of elements supporting various operations.

    //How to Use Stream ?
    //Source, Intermediate Operation & Terminal Operation


    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        //Without Stream
        int cnt1=0; //even number count
        for(int i: numbers){
            if(i%2==0){
                cnt1++;
            }
        }
        System.out.println(cnt1);


        //With Stream
        long cnt2 = numbers.stream().filter(i->i%2==0).count();
        System.out.println(cnt2);


        //Creating Stream
        //1. From Collections
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream();

        //2. From Arrays
        String[] strArr = {"ab","bc","ca"};
        Stream<String> stream1 = Arrays.stream(strArr);

        //3. Using Stream.of() -> Direct Method
        Stream<Integer> stream2 = Stream.of(11, 22, 33, 44);

        //4. Infinite Stream
        Stream<Integer> stream3 = Stream.generate(() -> 1); //infinite stream with all elements '1'
        List<Integer> collect = Stream.iterate(0, x -> x + 1).limit(40).collect(Collectors.toList());
        System.out.println(collect);

    }
}
