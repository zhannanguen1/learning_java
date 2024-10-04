package net.xonich.exceptions;

public class ExceptionsDemo {

    public static void main(String[] args) {
        try {
            foo1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void foo1() {

        foo2();
    }

    public static void foo2() {

        try {
            foo3();
        } catch (RuntimeException e) {
            System.out.println();
        }

    }

    public static void foo3() {

        foo4();
    }

    public static void foo4() {

        foo5();
    }

    public static void foo5() {

        bar();
    }

    public static void bar() throws RuntimeException {

        if (Math.random() > 0) {
            throw new RuntimeException();
        }
    }
}
