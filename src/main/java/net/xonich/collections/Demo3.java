package net.xonich.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>();
        l.add("foo");
        l.add("bar");
        l.add("qwe");
//        Iterator<String> it = l.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        for(Iterator<String> i = l.iterator(); i.hasNext();){
//
//            String x = i.next();
//        }

        for (String x : l) {

        }

//        List.add("foo");

        MyArrayList myArrayList = new MyArrayList();
        for (int i = 1; i <= 10; i++) {
            myArrayList.add(i);
        }
//        for (Iterator<Integer> it = myArrayList.iterator(); it.hasNext(); ) {
//            int a = it.next();
//            System.out.println(a);
//        }
        Iterator<Integer> it1 = myArrayList.iterator();
        it1.next();
        it1.remove();
        it1.next();
        it1.next();
        it1.next();
        it1.remove();
        it1.next();
        it1.next();
        it1.next();
        it1.next();
//        it1.next();


        System.out.println();
    }

    public static void foo(String[] args) {
        int l = 10;
    }
}
