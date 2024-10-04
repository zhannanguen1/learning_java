package net.xonich.exceptions;

public class ExceptionDemo2 {

    public static void main(String[] args) throws Exception {

        foo();
    }

    public static void foo() throws Exception {
        bar();
    }

    public static void bar() throws Exception {

        throw new Exception();
    }

    public static void foo2() {

        try {
            bar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
