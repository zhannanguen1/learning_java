package net.xonich.collections;

public class Demo1 {

    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();
        System.out.println("list.size() = " + list.size());
        list.add(42);
        list.add(101);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.size() = " + list.size());

        for (int i = 0; i < 10; i++) {

            list.add(i*i);
        }
        System.out.println("list.size() = " + list.size());
    }
}
