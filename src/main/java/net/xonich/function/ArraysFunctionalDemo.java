package net.xonich.function;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.IntStream;

public class ArraysFunctionalDemo {

    public static void main(String[] args) {

        Integer[] numbers = {5, 2, 8, 1, 9, 3};
        Integer[] numbers2 = {5, 2, 8, 1, 9, 3};
        int[] nums = {1, 2, 8, 3};
        String[] words = {"java", "python", "c++", "javascript"};

        Function<int[], String> toString = Arrays::toString;
        BiPredicate<Integer[], Integer[]> arrayComparator = Arrays::equals;
        System.out.println("Array to string: " + toString.apply(nums));
        System.out.println("Arrays equal: " + arrayComparator.test(numbers, numbers2));

        BiConsumer<int[], Integer> arrayFiller = Arrays::fill;
        int[] copy = nums.clone();
        arrayFiller.accept(copy, 0);

        ToIntBiFunction<int[], Integer> binarySearcher = Arrays::binarySearch;
        Arrays.sort(numbers);
        int index = binarySearcher.applyAsInt(nums, 8);
        System.out.println("index = " + index);

        Function<int[], IntStream> streamCreator = Arrays::stream;
        streamCreator.apply(nums).forEach(System.out::println);

        Arrays.stream(words).map(String::toUpperCase).forEach(System.out::println);

    }

}
