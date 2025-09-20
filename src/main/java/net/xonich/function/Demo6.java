package net.xonich.function;

import java.util.*;
import java.util.stream.Stream;

public class Demo6 {

    public static void mainCount(String[] args) {

        List<String> strings = List.of("aa", "bb", "ab", "dfdf", "zhanna");
        Stream<String> stream = strings.stream();
//        stream.parallel();
        System.out.println(stream.count());
//        System.out.println(stream.count());
    }

    public static void main(String[] args) {

        List<String> strings = List.of("aa", "bb", "ab", "dfdf", "zhanna");
        long cnt = strings.stream()
                .filter(string -> string.startsWith("a"))
                .count();

        System.out.println(cnt);

        List<String> list = strings.stream()
                .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1))
                .toList();

        System.out.println(list);

        strings.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        boolean allMatch = strings.stream()
                .filter(s -> s.charAt(0) != 'd' && s.charAt(0) != 'z')
                .allMatch(s -> s.length() == 2);

        System.out.println(allMatch);

        Optional<String> max = strings.stream()
                .max(Comparator.naturalOrder());

        System.out.println(max);
    }
}
