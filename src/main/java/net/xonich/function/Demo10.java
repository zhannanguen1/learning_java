package net.xonich.function;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Demo10 {

    public static void main(String[] args) {

        List<Group> groups = Arrays.asList(
                new Group("1A",
                        Arrays.asList(
                                new Person("Иван", "Иванов", LocalDate.of(2010, 5, 10)),
                                new Person("Сергей", "Смирнов", LocalDate.of(2010, 7, 22)),
                                new Person("Андрей", "Козлов", LocalDate.of(2011, 1, 15)),
                                new Person("Дмитрий", "Попов", LocalDate.of(2010, 9, 30)),
                                new Person("Алексей", "Волков", LocalDate.of(2011, 4, 12))
                        ),
                        Arrays.asList(
                                new Person("Мария", "Петрова", LocalDate.of(2011, 3, 20)),
                                new Person("Анна", "Соколова", LocalDate.of(2010, 11, 5)),
                                new Person("Екатерина", "Морозова", LocalDate.of(2011, 2, 18)),
                                new Person("Ольга", "Новикова", LocalDate.of(2010, 8, 9)),
                                new Person("Татьяна", "Лебедева", LocalDate.of(2011, 6, 25)),
                                new Person("Наталья", "Зайцева", LocalDate.of(2010, 12, 1))
                        )
                ),
                new Group("2B",
                        Arrays.asList(new Person("Сергей", "Сидоров", LocalDate.of(2010, 8, 15))),
                        Collections.emptyList()
                ),
                new Group("3C",
                        Collections.emptyList(),
                        Arrays.asList(new Person("Анна", "Кузнецова", LocalDate.of(2011, 1, 5)))
                )
        );

        List<String> allNames = groups.stream()
                .flatMap(group -> Stream.concat(
                        group.boys.stream(),
                        group.girls.stream()
                ).map(Person::getFirstName))
                .toList();

        List<String> allNames2 = groups.stream()
                        .flatMap(group ->
                                Stream.of(group.boys, group.girls)
                                        .flatMap(List::stream)
                                        .map(Person::getFirstName))
                                .toList();

//        groups.stream()
//                        .flatMap(g -> Stream.builder())

        allNames.forEach(System.out::println);
        allNames2.forEach(System.out::println);
    }

    public static class Group {

        private String groupName;
        private List<Person> boys;
        private List<Person> girls;

        public Group(String groupName, List<Person> boys, List<Person> girls) {
            this.groupName = groupName;
            this.boys = boys;
            this.girls = girls;
        }
    }

    public static class Person {

        private String firstName;
        private String lastName;
        private LocalDate birthday;

        public Person(String firstName, String lastName, LocalDate birthday) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getBirthday() {
            return birthday;
        }
    }
}
