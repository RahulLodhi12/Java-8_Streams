import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamIntro {
    /*
    - A Stream in Java 8 is a feature that lets you process collections of data (like lists, sets, arrays)
      in a clean, fast, and functional way.
    - Instead of writing loops, you can use stream operations to filter, map, and collect data.

    Key Points:
    1. Not a Data Structure → A stream doesn’t store data; it just processes it.
    2. Functional Style → Focus on what to do, not how to do.
    */

    public static void main(String[] args){
        //Without Stream
        List<String> names = Arrays.asList("Rohit","Rahul","Virat","Ishan");
        List<String> res = new ArrayList<>();

        for(String name: names){
            if(name.startsWith("R")){
                res.add(name.toUpperCase());
            }
        }
        System.out.println(res);


        //With Stream (Java 8)
        List<String> boys = Arrays.asList("Rohit","Rahul","Virat","Ishan");

        //Lambda Expression
//        List<String> ans = boys.stream().filter(n->n.startsWith("R")).map(n->n.toUpperCase()).toList();
        //Method Reference
        List<String> ans = boys.stream().filter(n->n.startsWith("R")).map(String::toUpperCase).toList();

        System.out.println(ans);


        /*
        Thumb Rule: For when to use method reference
        👉 If the method reference’s signature (input/output) matches the functional interface[Predicate: boolean test(T t),
        Function: R apply(T t), Consumer: void accept(T t), Supplier: T get()] expected by the stream method, you can use it.
        Otherwise, use a lambda.
        */

        /*
        Example 1: map() expects Function<T,R>
        List<String> names = Arrays.asList("rahul", "rohit", "virat");
        // Lambda
        List<String> upper1 = names.stream()
                               .map(s -> s.toUpperCase()) // input: String, output: String
                               .toList();
        // Method reference
        List<String> upper2 = names.stream()
                                   .map(String::toUpperCase) // also String -> String ✅ matches Function<T,R>
                                   .toList();
        ✔ Works because String::toUpperCase matches Function<String,String>.


        Example 2: filter() expects Predicate<T>
        List<String> names = Arrays.asList("Rahul", "Rohit", "Virat");
        // Lambda
        List<String> onlyRahul1 = names.stream()
                                       .filter(s -> s.equals("Rahul")) // input: String, output: boolean
                                       .toList();
        // Method reference
        List<String> onlyRahul2 = names.stream()
                                       .filter("Rahul"::equals) // also String -> boolean ✅ matches Predicate<T>
                                       .toList();
        ✔ Works because "Rahul"::equals matches Predicate<String>.


        Example 3: forEach() expects Consumer<T>
        List<String> names = Arrays.asList("Rahul", "Rohit");
        // Lambda
        names.forEach(s -> System.out.println(s)); // input: String, output: void
        // Method reference
        names.forEach(System.out::println); // also String -> void ✅ matches Consumer<T>
        ✔ Works because System.out::println matches Consumer<String>.

        🚀 Key Takeaway:
        - Look at what the stream method expects (Function, Predicate, Consumer, BinaryOperator, etc.).
        - Check if your method reference has the same input/output shape.
        - If it matches → ✅ method reference works.
        - If not → ❌ use a lambda.
        */


        /*
        Reason: Why we can't use Method Reference in filter(n->n.startsWith("R")) -> 2 inputs: "n" and "R"
        Ans. Inside filter() Predicate "boolean test(T t)" is used and this test(T t) requires 1 input.
        But, When you write "String::startsWith", Java interprets it as:
              (s, prefix) -> s.startsWith(prefix)
        👉 This is a BiPredicate<String, String> (takes 2 inputs: the string s and the prefix).
        But filter does not want a BiPredicate.
        It only wants a Predicate (one input).

        NOTE: In case of .filter(s -> s.equals("Rahul")):
        .filter("Rahul"::equals)  //Java interprets to s -> "Rahul".equals(s) -> This is Predicate
        */
    }
}
