package net.xonich.files;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class DemoFiles3 {

    public static void main2(String[] args) throws IOException {

        String fileName = "D:\\temp\\HomeWork\\FileLF.txt";
        FileReader fr = new FileReader(fileName, Charset.forName("Windows-1251"));

        int x;
        while ((x = fr.read()) != -1) {
            System.out.print((char) x);
        }
    }

    public static void main3(String[] args) throws IOException {

        String fileName = "D:\\temp\\HomeWork\\FileLF.txt";
        StringWriter sw = new StringWriter();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        for (String s; (s = br.readLine()) != null; ) {
            System.out.println(s);
        }
    }

    public static void main4(String[] args) {

        Scanner sc = new Scanner("тут текст только с lf\n" +
                "The exception you see - that I would strongly recommend a) to catch as a specific type, e.g. \n" +
                "IOException, and b) to log or show with a message or a stack trace, and c) at least to check \n" +
                "for in LogCat, from the DDMS perspective if you are programming with Eclipse - is probably due to \n" +
                "Android not finding the config.txt file you are trying to open. Usually, \n" +
                "for the simplest cases such as yours, files that are private to an application\n" +
                " are opened using openFileInput - see the documentation for details.");
        String s;
        while ((s = sc.next("(are)|(is)|(am)")) != null) {
            System.out.println(s);
        }; //todo

    }

    public static void main(String[] args) {

        DemoFiles3.class.getClassLoader().getResourceAsStream("test.txt");
    }
}
