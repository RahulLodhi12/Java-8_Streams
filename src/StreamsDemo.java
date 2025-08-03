import java.util.function.Function;
import java.util.function.Predicate;

public class StreamsDemo {
    public static void main(String[] args) {

        //Lambda Expression -> Used to provide Body to Functional Interface abstract method.
        Thread t1 = new Thread(()->{ //run() method
            System.out.println("Thread is running..");
        });
//        t1.start();

        //if single statement -> eliminate "return" statement and "{ curly parentheses }"
        MathOps sumOp = (a, b)->a+b;
        double res = sumOp.operate(11,22);
        System.out.println(res);


        //Predicate -> Functional Interface -> single abstract method -> test(Anything) -> boolean return type
        Predicate<Integer> isEven = (val)->val%2==0;
        System.out.println(isEven.test(6));

        Predicate<String> isWordStartsWithA = (word)->word.toLowerCase().startsWith("a");
        Predicate<String> isWordEndsWithT = (word)->word.toLowerCase().endsWith("t");
        Predicate<String> wordStartsWithA_and_EndsWithT = isWordStartsWithA.and(isWordEndsWithT); //"and" is default method, means it has body
        System.out.println(wordStartsWithA_and_EndsWithT.test("aryan"));

        //Function
        Function<Integer,Integer> doubleIt = (val)->val*2; //doubleIt holds a reference to this lambda function.(object)
        //"holds a reference" means it holds a memory address pointing to the lambda function object.
        //Objects (including lambdas) are stored in memory (typically heap).
        //Variables like doubleIt don’t hold the actual object — they hold a reference to where the object (lambda) is stored in memory.
        //So, doubleIt is pointing to the memory location of the lambda (val) -> val * 2.
        System.out.println(doubleIt.apply(23));
        //.apply(23) calls the lambda function with input 23.
        //Internally, it evaluates 23 * 2, which gives 46.


        Function<Integer,Integer> tripleIt = (val)->val*3;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));//20*2 = 40*3 = 120
        System.out.println(doubleIt.compose(tripleIt).apply(30));//30*3 = 90*2 = 180

        System.out.println(Function.identity().apply(51)); //"identity" method is a static -> no object is needed -> "ClassName.MethodName()" to access the static methods
        //Function.identity() -> It returns a lambda expression: (t -> t)
    }
}

//class Task implements Runnable{
//
//    @Override
//    public void run(){
//        System.out.println("Thread is running..");
//    }
//}

//class SumOp implements MathOps{
//
//    @Override
//    public double operate(double a, double b){
//        return a+b;
//    }
//}

interface MathOps{
    double operate(double a, double b);
}


