package net.xonich.collections;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {

    public static void main(String[] args) {

        String[] strings = new String[10];
        strings[0] = "qwe";
//        Object[] objects = strings;
//        objects[1] = 42;

        List<String> strs = new ArrayList<>();
        strs.add("asd");
//        List<Object> objs = strs;

        Integer i = 42;
        Long l = 11L;
        Number n = l;
    }
}
