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
        for (int i = 0; i < 4; i++) {
            list.add((i + 1) * (i + 1));
        }
//        System.out.println("list.size() = " + list.size());
//
//        list.set(0, 88);
//        System.out.println("list.get(0) = " + list.get(0));

        list.s();
        list.set(7, 7);
        list.s();
        list.remove(2);
        list.s();
        list.set(0, 55);
        list.s();
        System.out.println("list.size() = " + list.size());
        list.set(9, 66);
        System.out.println("list.size() = " + list.size());
        list.s();
        list.remove(5);
        System.out.println("list.size() = " + list.size());
        list.s();
    }
}
