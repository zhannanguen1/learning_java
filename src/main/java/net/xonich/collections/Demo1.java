package net.xonich.collections;

public class Demo1 {

    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();
//        System.out.println("list.size() = " + list.size());
//        list.add(42);
//        list.add(101);
//        System.out.println("list.get(0) = " + list.get(0));
//        System.out.println("list.get(1) = " + list.get(1));
//        System.out.println("list.size() = " + list.size());
//
        for (int i = 0; i < 10; i++) {
            list.add((i + 1) * (i + 1));
        }
//        System.out.println("list.size() = " + list.size());
//
//        list.set(0, 88);
//        System.out.println("list.get(0) = " + list.get(0));
        
//        list.set(7, 7);
//        list.remove(2);
//        list.set(0, 55);
//        System.out.println(list);
//        System.out.println("list.size() = " + list.size());
////        list.set(9, 66);
//        System.out.println("list.size() = " + list.size());
//        System.out.println(list);
////        list.remove(5);
//        System.out.println("list.size() = " + list.size());
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.add(42);
        System.out.println(list);

    }
}
