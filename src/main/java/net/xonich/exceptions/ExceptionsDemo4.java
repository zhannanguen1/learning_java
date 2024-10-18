package net.xonich.exceptions;

public class ExceptionsDemo4 {

    public static void main(String[] args) throws Exception {

        Exception ex = bar();
        throw ex;
    }

    public static Exception bar() {

        return new Exception();
    }
}
