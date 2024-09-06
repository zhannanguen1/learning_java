package net.xonich.files;

import java.io.File;
import java.io.IOException;

public class DemoFiles {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\temp");
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
