package net.xonich.files;

import java.io.*;

public class DemoFiles2 {
    public static void fileRead(String[] args) throws IOException {

        InputStream fis = new FileInputStream("D:\\temp\\readme.txt");
        int a = fis.read();
        while (a != -1) {
            System.out.println((char) a + " = " + a + " " + Integer.toBinaryString(a));
            a = fis.read();
        }
        fis.close();
    }

    public static void main(String[] args) throws IOException {

        OutputStream fos = new FileOutputStream("D:\\temp\\readme2.txt");
        fos.write("a".getBytes());
//        fos.flush();
        System.in.read();
        fos.close();
    }

}
