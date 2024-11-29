package net.xonich.collections;


public class Demo1 {

    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 1; i++) {
            list.add((i + 1) * (i + 1));
        }
//        System.out.println(list);
//        System.out.println("list.get(5) = " + list.get(5));
//        list.set(5, 7);
//        System.out.println("list.get(5) = " + list.get(5));

        System.out.println(list);
//        System.out.println("list.size() = " + list.size());
        list.add(10, 999);
        list.add(999);
//        System.out.println("list.size() = " + list.size());
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
//
//        StringToLinkedList stringToLinkedList = new StringToLinkedList();
//        StringToLinkedList cola = stringToLinkedList.toLL("cocacola");
//        cola.printList();
    }

    public class Test {

        public static void test() {
            
        }
        public void tt() {
            test();
        }
    }

}
