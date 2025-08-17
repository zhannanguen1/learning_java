package net.xonich.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Demo1Lambda {

    public static void anonymousClass(String[] args) {

        Runnable task = new Runnable() {
            @Override
            public void run() {

            }
        };

        System.out.println();
    }

    public static void lambdaExample(String[] args) {

        String prefix = "0x";
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return prefix + Integer.toHexString(integer);
            }
        };

        Function<Integer, String> functionL = (Integer i) -> {
            return Integer.toHexString(i);
        };

        Function<Integer, String> functionL1 = (i) -> {
            return prefix + Integer.toHexString(i);
        };

        Function<Integer, String> functionL2 = i -> {
            return Integer.toHexString(i);
        };

        Function<Integer, String> functionL3 = i -> Integer.toHexString(i);

        Function<Integer, String> functionL4 = Integer::toHexString;

        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        ints.stream().map(functionL1).forEach(System.out::println);
//        prefix = "2";

//        ints.stream().forEach((el) -> System.out.println(el));

    }

    public static void main(String[] args) {

        Runnable r = () -> System.out.println("Hello, World!");
        Supplier<String> s = () -> "Hello, World!";
        Consumer<String> c = str -> System.out.println("str: " + str);
        Function<String, String> f = str -> str.substring(0, 2);
        BiFunction<String, Integer, String> biFunction = (str, i) -> str.repeat(i);
        BiConsumer<String, Integer> biConsumer = (string, integer) -> System.out.println(string.charAt(integer));

    }
}
