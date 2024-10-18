package net.xonich.exceptions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class ExceptionsDemo3 {

    public static void main(String[] args) {

        oom();
    }

    public static void npe() {

        String s = null;
        s.length();
    }

    public static void npe2() {

        Integer i = null;
        int x = i;
    }

    public static void classCastEx() {

        InputStream inputStream = System.in;
//        if (inputStream instanceof FileInputStream) {} безопасн каст
        FileInputStream fis = (FileInputStream) inputStream;
    }

    public static void arrayIOB() {

        int[] a = {1, 2, 3};
        a[4] = 5;
    }

    public static void arithmeticEx() {

        int a = 0;
        int b = 1/a;
    }

    public static void oom() {

        int[] a = new int[2_000_000_000];
    }
}
