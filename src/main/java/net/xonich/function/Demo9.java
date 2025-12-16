package net.xonich.function;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo9 {


    public static void main(String[] args) {

        List<List<String>> lists = Arrays.asList(
                Arrays.asList("Jane", "Pasha", "Masha"),
                new ArrayList<>(),
                Arrays.asList("Kolya"),
                Arrays.asList("Nastya", "Goga")
        );

        lists.stream()
                .flatMap(x -> x.stream()) //сплющенный map
                .forEach(System.out::println);

        List<int[]> listInts = Arrays.asList(
                new int[]{12, 444, 123, 123},
                new int[0],
                new int[]{0, -33, 12},
                new int[]{10}
        );

        listInts.stream()
                .flatMapToInt(x -> Arrays.stream(x))
                .forEach(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");
        words.stream()
                .flatMap((String x) -> x.chars().mapToObj((int c) -> (char) c))
                .forEach(System.out::println);

//        words.stream()
//                .flatMap(x -> Arrays.stream(x.toCharArray())); // не сработает

        List<LocalDate> localDates = Arrays.asList(
                LocalDate.of(2025, Month.DECEMBER, 12),
                LocalDate.of(2025, Month.OCTOBER, 1),
                LocalDate.of(2025, Month.NOVEMBER, 10)
        );

        LocalTime midnight = LocalTime.of(0, 0);
        LocalTime morning = LocalTime.of(6, 0);
        LocalTime noon = LocalTime.of(12, 0);
        LocalTime evening = LocalTime.of(18, 0);

        for (LocalDate localDate : localDates) {
            System.out.println("LocalDateTime.of(localDate, midnight) = " + LocalDateTime.of(localDate, midnight));
            System.out.println("LocalDateTime.of(localDate, morning) = " + LocalDateTime.of(localDate, morning));
            System.out.println("LocalDateTime.of(localDate, noon) = " + LocalDateTime.of(localDate, noon));
            System.out.println("LocalDateTime.of(localDate, evening) = " + LocalDateTime.of(localDate, evening));
        }

        localDates.stream()
                .flatMap(x -> Stream.of(LocalDateTime.of(x, midnight), LocalDateTime.of(x, morning), LocalDateTime.of(x, noon), LocalDateTime.of(x, evening)))
                .forEach(System.out::println);

        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime = now.atTime(midnight);
    }

    class Group {

        String groupName;
        List<Person> boys;
        List<Person> girls;
    }

    class Person {

        String firstName;
        String lastName;
        LocalDate birthday;
    }
}
