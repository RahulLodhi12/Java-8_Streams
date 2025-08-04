import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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


        //Predicate -> Functional Interface -> single abstract method -> boolean test(Anything) -> boolean return type
        Predicate<Integer> isEven = (val)->val%2==0;
        System.out.println(isEven.test(6));

        Predicate<String> isWordStartsWithA = (word)->word.toLowerCase().startsWith("a");
        Predicate<String> isWordEndsWithT = (word)->word.toLowerCase().endsWith("t");
        Predicate<String> wordStartsWithA_and_EndsWithT = isWordStartsWithA.and(isWordEndsWithT); //"and" is default method, means it has body
        System.out.println(wordStartsWithA_and_EndsWithT.test("aryan"));


        //Function -> Functional Interface -> R apply(T t) -> R is the return type and T is type of argument.
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


        //Consumer -> Functional Interface -> void accept(T t) -> no return type
        Consumer<Integer> print = (val)-> {
            System.out.println(val);
            System.out.println(val*11);
        };
        print.accept(11);

        List<Integer> list = Arrays.asList(10, 20, 30);
        Consumer<List<Integer>> printList = (x)->{
            for(int i: x){
                System.out.println(i);
            }
        };
        printList.accept(list);

        //Supplier -> Functional Interface -> T get() -> e.g. can be used for DB connection.
        Supplier<String> getMsg = ()-> "helloWorld..!";
        System.out.println(getMsg.get());

        //Combined Example
        Predicate<Integer> even = (x)-> x%2==0; //boolean
        Function<Integer,Integer> square = (x)-> x*x; //integer(or any)
        Consumer<Integer> value = (x)-> System.out.println(x); //no return-type
        Supplier<Integer> number = ()-> 124; //integer(or any)

        if(even.test(number.get())){
            value.accept(square.apply(number.get()));
        }

        //Functional Interface with 2 arguments
        //BiPredicate, BiFunction, BiConsumer

        //BiPredicate -> Functional Interface -> boolean test(T t, U u)
        BiPredicate<Integer,Integer> isSumEven = (x,y)-> (x+y)%2==0;
        System.out.println(isSumEven.test(11,22));

        //BiConsumer -> Functional Interface -> void accept(T t, U u)
        BiConsumer<Integer,String> biConsumer = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept(14,"bapu-ji");

        //BiFunction -> BiFunction<T, U, R>   ---->   R apply(T t, U u);
        BiFunction<String,String,Integer> biFunction = (x,y)-> (x+y).length();
        System.out.println(biFunction.apply("ab","cd"));

        //UnaryOperator<T> equals to Function<T,T>
        UnaryOperator<Integer> unaryOperator = (x)-> x*2;
        System.out.println(unaryOperator.apply(23));

        //BinaryOperator<T> equals to BiFunction<T,T,T>
        BinaryOperator<Integer> binaryOperator = (x,y)-> x+y;
        System.out.println(binaryOperator.apply(33,66));
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


