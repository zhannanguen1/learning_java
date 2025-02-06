package net.xonich.collections;

import java.util.HashMap;

public class HashMapDemo {

    static Object dummy = new Object();

    public static void main_1(String[] args) {

        String s = "qwd";
        System.out.println("s.hashCode() = " + s.hashCode());

        System.out.println("\"foo\".hashCode() = " + "foo".hashCode());
        System.out.println("\"bar\".hashCode() = " + "bar".hashCode());
        System.out.println("\"qwe\".hashCode() = " + "qwe".hashCode());

        HashMap<String, Object> hm = new HashMap<>(2, 0.01f);
        hm.put("foo", dummy);
        hm.put("bar", dummy);
        hm.put("qwe", dummy);

        System.out.println(hm);
    }

    public static void main(String[] args) {

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("Masha", dummy);
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.contains(\"Masha\") = " + myHashMap.contains("Masha"));
        myHashMap.put("Masha", dummy);
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.put("Misha", dummy);
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("\"Masha\".hashCode() = " + "Masha".hashCode() % 16);
        System.out.println("\"Misha\".hashCode() = " + "Misha".hashCode() % 16);
        System.out.println("\"Sasha\".hashCode() = " + "Sasha".hashCode() % 16);
        System.out.println("\"Kirill\".hashCode() = " + "Kirill".hashCode() % 16);
        System.out.println("\"Gosha\".hashCode() = " + "Gosha".hashCode() % 16);
        System.out.println("\"Anna\".hashCode() = " + "Anna".hashCode() % 16);
        System.out.println("\"Katya\".hashCode() = " + "Katya".hashCode() % 16);
        myHashMap.put("Sasha", dummy);
        myHashMap.put("Kirill", dummy);
        myHashMap.put("Gosha", dummy);
        myHashMap.put("Anna", dummy);
        myHashMap.put("Katya", dummy);
        System.out.println("myHashMap.contains(\"Anna\") = " + myHashMap.contains("Anna"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.put("Senya", dummy);
        myHashMap.put("Nadya", dummy);
        myHashMap.put("Ulya", dummy);
        myHashMap.put("Kristina", dummy);
        myHashMap.put("Kseniya", dummy);
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.put("Oksana", dummy);
        myHashMap.put("Lera", dummy);
        myHashMap.put("Natasha", dummy);
        myHashMap.put("Dima", dummy);
        myHashMap.put("Olya", dummy);
        System.out.println("myHashMap.size() = " + myHashMap.size());
    }
}









































