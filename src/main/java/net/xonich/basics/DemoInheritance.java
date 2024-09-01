package net.xonich.basics;

public class DemoInheritance {

    public static void main(String[] args) {

        class Data1 {
            int num = 10;
            void printNum() {
                System.out.println(num);
            }
        }

        class Data2 extends Data1 {
            int num = 20;
            void printNum() {
                System.out.println(num);
            }
        }

        Data2 data2 = new Data2();
        System.out.println(data2.num);
        Data1 data1 = data2;
        System.out.println(data1.num);
        data2.printNum();
        data1.printNum();

    }
}
