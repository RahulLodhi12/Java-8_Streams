import java.util.Arrays;
import java.util.List;
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



        Stream<Integer> stream = numbers.stream();

    }
}
