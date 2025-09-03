package net.xonich.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Demo2MethodReference {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Melon", "Grape"));

//        stringList.sort(Comparator.naturalOrder());

        Consumer<Comparator<String>> sorter = stringList::sort;
//        sorter.accept(Comparator.naturalOrder());

        BiConsumer<List<String>, Comparator<String>> yetAnotherSorter = List::sort;
        yetAnotherSorter.accept(stringList, Comparator.naturalOrder());


        System.out.println(stringList);

    }

//    public class List_ {
//
//        public static void sort(List_ this, Comparator<?> cmp) {}
//    }
}
