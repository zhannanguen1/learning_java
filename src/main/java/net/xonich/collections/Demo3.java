package net.xonich.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Demo3 {

    public static void main(String[] args) {

//        List<String> l = new ArrayList<>();
//        l.add("foo");
//        l.add("bar");
//        l.add("qwe");
//        Iterator<String> it = l.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        for(Iterator<String> i = l.iterator(); i.hasNext();){
//
//            String x = i.next();
//        }

//        for (String x : l) {
//
//        }

//        List.add("foo");

//        MyArrayList myArrayList = new MyArrayList();
//        for (int i = 1; i <= 10; i++) {
//            myArrayList.add(i);
//        }
////        for (Iterator<Integer> it = myArrayList.iterator(); it.hasNext(); ) {
////            int a = it.next();
////            System.out.println(a);
////        }
//        Iterator<Integer> it1 = myArrayList.iterator();
//        it1.next();
//        it1.remove();
//        it1.next();
//        it1.next();
//        it1.next();
//        it1.remove();
//        it1.next();
//        it1.next();
//        it1.next();
//        it1.next();
//        it1.next();

//        MyLinkedListStr mll = new MyLinkedListStr();
//        mll.addFirst("a");
//        mll.addFirst("J");
//        mll.addLast("v");
//        mll.addLast("a");
//
//        System.out.println(mll.getSize());

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(111);
        System.out.println();
        myLinkedList.addLast(222);
        myLinkedList.addLast(333);
        myLinkedList.addLast(444);
        System.out.println();
        Iterator<Integer> it1 = myLinkedList.iterator(); //toDo
        for (Integer i : myLinkedList) {
            System.out.println("i = " + i);
        }
        Integer next1 = it1.next(); // 111
        Integer next2 = it1.next(); // 222
        it1.remove();
        Integer next3 = it1.next(); // 333
        it1.remove();
        Integer next4 = it1.next(); // 444
//        myLinkedList.addFirst(111);

        System.out.println();
    }

    public static void foo(String[] args) {
        int l = 10;
    }
}
