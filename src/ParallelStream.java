import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    //A type of stream that enables parallel processing of elements
    //Allowing multiple threads to process parts of the stream simultaneously
    //This can significantly improve performance for large data sets, because workload is distributed across multiple threads
    
    public static void main(String[] args){
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        long startTime = System.currentTimeMillis();
        List<Long> fact = list.stream().map(x -> factorial(x)).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        fact = list.parallelStream().map(x -> factorial(x)).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime-startTime) + "ms");

        //Parallel Streams are most effective for CPU-intensive or large datasets where tasks are independent.
        //They may add overhead for simple tasks or small datasets, this will drop the performance.

        //Cumulative Sum
        //[1,2,3,4,5] -> [1,3,6,10,15]
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        //With Stream
        AtomicInteger sum= new AtomicInteger();
        List<Integer> cumulativeSum = nums.stream().map(x -> {
            int val = x + sum.get();
            sum.set(val);
            return val;
            //Why Variable used in lambda expression should be final or effectively final ??
            //Because, lambdas don’t really store the variable itself — they capture its value.
            //If the variable could change later, it would be confusing: the lambda wouldn’t know which value to use.
        }).toList();
        System.out.println("With Stream: "+cumulativeSum);

        //With Parallel-Stream
        AtomicInteger sum1= new AtomicInteger();
        List<Integer> cumulativeSum1 = nums.parallelStream().map(x -> {
            int val = x + sum1.get();
            sum1.set(val);
            return val;
        }).toList();
        System.out.println("With Parallel-Stream: "+cumulativeSum1);
    }

    public static long factorial(int n){
        long res=1;
        for(int i=2;i<=n;i++){
            res*=i;
        }

        return res;
    }
}
