package net.xonich.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

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
        }
        ; //todo

    }

    public static void main5(String[] args) {

        DemoFiles3.class.getClassLoader().getResourceAsStream("test.txt");
    }

    public static void main(String[] args) {

        test();
    }
    public static boolean isValid(String addr) {

        List<String> addressParts = Arrays.stream(addr.split("\\.")).toList();

        if (addressParts.size() == 4) {
            for (String addressPart : addressParts) {
                try {
                    if (addressPart.length() > 1 && addressPart.startsWith("0")) {
                        return false;
                    }
                    int num = Integer.parseInt(addressPart);
                    if (num > 255) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void test() {
        String[] testList = {
                "123.54.3.444",
                "444.54.3.111",
                "111.54.3.1a1",
                "54344444",
                "123.22.33",
                "043.8.5.111",
                "143.0.5.111",
                "0.0.0.0"
        };

        boolean[] correctAnswers = {false, false, false, false, false, false, true, true};

        boolean result;
        for (int i = 0; i < testList.length; i++) {
            result = isValid(testList[i]);

            if (result == correctAnswers[i]) {
                System.out.println(testList[i] + " ok");
            } else {
                System.out.println(testList[i] + " этот тест не прошел. Ожидалось: " + correctAnswers[i]);
            }
        }
    }
}
