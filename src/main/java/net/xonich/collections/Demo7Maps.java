package net.xonich.collections;

import lombok.ToString;

import java.util.*;

public class Demo7Maps {

    @ToString
    public static class Person {

        private String name;
        private int age;
        private String city;


        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }
    }

    public static void main(String[] args) {

        Collection<Person> people = new ArrayList<>( List.of(
                new Person("Misha", 10, "Msk"),
                new Person("Pashas", 10, "Spb"),
                new Person("Anna", 22, "Ekt")
        ));

        Map<Integer, List<Person>> personMap = new HashMap<>();
        people.removeIf(person -> {

            return person.name.endsWith("a");
        });

        System.out.println(people);

        for (Person person : people) {
            personMap.computeIfAbsent(person.age, (Integer age) -> {

                return new ArrayList<>();
            }).add(person);
//            personMap.putIfAbsent(person.age, new ArrayList<>());
        }


    }

    public static Map<Integer, List<Person>> buildPeopleAgeIndex(Collection<Person> people) {

        Map<Integer, List<Person>> personMap = new HashMap<>();

        for (Person p : people) {

            if (!personMap.containsKey(p.age)) {

                personMap.put(p.age, new ArrayList<>());
            }
            personMap.get(p.age).add(p);
        }

        return personMap;
    }
}
