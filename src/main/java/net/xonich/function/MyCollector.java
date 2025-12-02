package net.xonich.function;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class MyCollector {

    public static <T> Collector<T, ?, CopyOnWriteArrayList<T>> toCopyOnWriteArrayList() {

        Supplier<ArrayList<T>> supplier = ArrayList::new;
        BiConsumer<ArrayList<T>, T> accumulator = ArrayList::add;
        BinaryOperator<ArrayList<T>> combiner = (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
        Function<ArrayList<T>, CopyOnWriteArrayList<T>> finisher = CopyOnWriteArrayList::new;

        return Collector.of(
                supplier, // создает ArrayList
                accumulator, // наполняет ArrayList
                combiner, // объединяет для листа
                finisher // оборачивает результат в CopyOnWriteArrayList
        );
    }

    public static void main(String[] args) {

        List<String> result1 = Stream.of("apple", "banana", "cherry")
                .collect(MyCollector.toCopyOnWriteArrayList());

        System.out.println("Результат: " + result1);
        System.out.println("Тип: " + result1.getClass());
    }
}
