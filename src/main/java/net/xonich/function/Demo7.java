package net.xonich.function;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo7 {

    public static void main(String[] args) {

        List<String> stringList = List.of("apple", "banana", "orange", "grape", "pear");
        Supplier<TreeSet<String>> hashSetSupplier = () -> new TreeSet<>(Comparator.reverseOrder());
        BiConsumer<TreeSet<String>, String> accum = TreeSet::add;
//        BiConsumer<TreeSet<String>, TreeSet<String>> combiner = (h1, h2) -> {throw new RuntimeException();};
        BiConsumer<TreeSet<String>, TreeSet<String>> combiner = TreeSet::addAll;


        TreeSet<String> collected = stringList.stream()
                .parallel()
                .collect(hashSetSupplier, accum, combiner);

        System.out.println(collected);


        Function<String, String> keyMapper = Function.identity();// s -> s;
        Function<String, Integer> valueMapper = String::length;

        Map<String, Integer> stringIntegerMap = stringList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(stringIntegerMap);

        Map<Integer, List<String>> listMap = stringList.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(listMap);

        String s = stringList.stream()
                .collect(Collectors.joining(";"));

        System.out.println(s);
    }
}
