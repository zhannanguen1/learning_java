package net.xonich.files;

import java.io.File;
import java.io.IOException;

public class DemoFiles {

    public static void main(String[] args) throws IOException {

        File folder = new File("D:\\temp"); // Создаем объект File с путем к нему
        printFilesTree(folder, 0); // вызываем метод, передаем туда путь к корнеыой попке и кол-вом отстепов
    }

    public static void printFilesTree(File fileObject, int indentCount) { //создаем метод

        if (fileObject.isDirectory()) { //проверяем, является ли объект папкой
            System.out.println("\t".repeat(indentCount)+ "/" + fileObject.getName() + ": "); // если да, то печатаем его название с отступом 0
            File[] files = fileObject.listFiles(); // переходим во внутрь этой папки
            for (File f : files) { // берем каждый элемент из этой папки
                printFilesTree(f, indentCount + 1); // снова проверяем каждый файл и если доходим до этой строки, увеличиваем кол-во отступов на 1
            }
        } else {
            System.out.println("\t".repeat(indentCount) + fileObject.getName()); // если файл - это файл, печатаем его название
        }
    }

}
