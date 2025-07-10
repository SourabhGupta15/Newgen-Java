package practice.lambdas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdasDemo {
    // public static String prefix = "-";
    // public String prefix = "-";

    public LambdasDemo(String message) {}

    public void print(String message) {
        System.out.println("Hello");
    }

    public static void show() {
        // greet(new ConsolePrinter());

        // greet(new Printer() {       //Anonymous Inner class implementing Printer interface. No need to write separate ConsolePrinter class if it is used only once. this keyword in anonymous inner classes references to current instance of the anonymous inner class.
        //     @Override
        //     public void print(String message) {
        //         System.out.println(message);
        //     }
        // });

        // greet(message -> System.out.println(message));      //Lambda expression. We use greet(() -> {}), the inner paranthesis() when we have no or multiple parameters and use {} when we have multiple lines of code in greet().

        // Printer printer = message -> System.out.println(message);   //Storing lamnbda expression in a variable.
        // greet(printer);

        // String prefix = "-";
        // greet(message -> System.out.println(prefix + message));      //Can access local variables, static class members from static method and non-static class members from non-static method using this keyword.
        // greet(message -> System.out.println(this.prefix +message));

        // greet(System.out::println);     //lambda expression using method reference.

        // greet(message -> print(message));   //Calls print() of LamdasDemo which is declared as static method.
        // greet(LambdasDemo::print);          //Same as above.

        // var demo = new LambdasDemo();
        // greet(message -> demo.print(message));  //Calls print() of LambdasDemo which is declared as non-static method.
        // greet(demo::print);         //Same as above.

        greet(message -> new LambdasDemo(message));     //Calls constructor of LamdasDemo class
        greet(LambdasDemo::new);                        //Same as above
    }

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void showConsumer() {
        // List<Integer> list = List.of(1, 2, 3);

        // Imperative Programming Paradigm/Style : Specifies - How it needs to be done
        // for (var item : list)
        //     System.out.println(item);

        // Declarative Programming Paradigm/Style : Specifies - What needs to be done
        // list.forEach(item -> System.out.println(item));
        
        List<String> list = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        list.forEach(print.andThen(printUpperCase).andThen(print)); //Consumer chaining.
    }

    public static void showSupplier() {
        Supplier<Double> getRandom = () -> Math.random();   //Supplier takes no parameter. Here it returns Math.random(). Math.random() is not executed until we explicitly call it in the below statement. It is called lazy evaluation.
        System.out.println(getRandom.get());
    }

    public static void showFunction() {
        // Function<String, Integer> map = str -> str.length();
        // System.out.println(map.apply("Sky"));

        // Given String  :  "key:value"
        // 1st Operation :  "key=value"
        // 2nd Operation : "{key=value}"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";
        var result = replaceColon
                        .andThen(addBraces)
                        .apply("key:value");

        result = addBraces
                    .compose(replaceColon)
                    .apply("key:value");    //compose() is similar to andThen() but it chains in reverse order.
        System.out.println(result);
    }

    public static void showPredicate() {
        // Predicate<String> isLongerThan5 = str -> str.length() > 5;
        // System.out.println(isLongerThan5.test("sky"));

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        // Predicate has 3 default functions and(), or(), negate() which refers to logical &&, ||, !.
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        Predicate<String> hasLeftOrRightBraces = hasLeftBrace.or(hasRightBrace);
        Predicate<String> hasNoLeftBrace = hasLeftBrace.negate();
        System.out.println(hasLeftAndRightBraces.test("{key:value}"));
        System.out.println(hasLeftOrRightBraces.test("{key:value}"));
        System.out.println(hasNoLeftBrace.test("{key:value}"));
    }

    public static void showBinaryOperator() {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));

        Function<Integer,Integer> square = a -> a * a;
        System.out.println(add.andThen(square).apply(1, 2));
    }

    public static void showUnaryOperator() {
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        System.out.println(increment.andThen(square).apply(1));
    }
}
