package net.xonich.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args) {
        // Было:
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        // Переделать в лямбда
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        Collections.sort(names, String::compareTo);
        names.sort(String::compareTo);
    }

    public static void main1(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        // Было:
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        // Переделать с использованием stream() и лямбды
        numbers.stream().filter(n -> n % 2 == 0).toList();
    }

    public static void main3(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "lambda");

        // Было:
        words.forEach(s -> System.out.println(s));
        //Стало:
        words.forEach(System.out::println);
    }
}
