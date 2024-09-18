package net.xonich.files;

import java.io.*;
import java.util.List;

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

    public static void fileWrite(String[] args) throws IOException {

        OutputStream fos = new FileOutputStream("D:\\temp\\readme2.txt");
        fos.write("a".getBytes());
//        fos.flush();
        System.in.read();
        fos.close();
    }

    public static void main2(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\temp\\HomeWork\\FileCRLF.txt");
        FileOutputStream fos = new FileOutputStream("D:\\temp\\HomeWork\\FileLF.txt");
        int symbol = fis.read();

        while (symbol != -1) {

            if (symbol != '\r') {
                fos.write(symbol);
            }
            symbol = fis.read();
        }
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\temp\\HomeWork\\DataForLinux.txt");
        FileOutputStream fos = new FileOutputStream("D:\\temp\\HomeWork\\DataForWin.txt");
        int symbol = fis.read();

        while (symbol != -1) {

            if (symbol == '\n') {
                fos.write('\r');
                fos.write(symbol);
            } else {
                fos.write(symbol);
            }
            symbol = fis.read();
        }
        fis.close();
        fos.close();
    }
}
