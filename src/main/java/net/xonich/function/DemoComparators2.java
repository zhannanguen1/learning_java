package net.xonich.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DemoComparators2 {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("1984", "Джордж Оруэлл", 1949));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 1997));
        books.add(new Book("Гарри Поттер и тайная комната", "Джоан Роулинг", 1999));
        books.add(new Book("Унесенные ветром", "Маргарет Митчелл", 1936));
        books.add(new Book("Три товарища", "Эрих Мария Ремарк", 1936));
        books.add(new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1943));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1878));
        books.add(new Book("Сто лет одиночества", "Габриэль Гарсиа Маркес", 1967));
        books.add(new Book("Сто лет одиночества", "Маркес Габриэль Гарсиа", 1967));

        books.sort(Comparator.naturalOrder());
        System.out.println(books);

        books.sort(Comparator.reverseOrder());
        System.out.println(books);
    }

    public static class Book implements Comparable<Book>{

        private String title;
        private String author;
        private int yearOfPublication;

        public Book(String title, String author, int yearOfPublication) {
            this.title = title;
            this.author = author;
            this.yearOfPublication = yearOfPublication;
        }

        @Override
        public int compareTo(Book other) {

            if (this.title.compareTo(other.title) > 0) {
                return 1;
            }
            if (this.title.compareTo(other.title) < 0) {
                return -1;
            }
            if (this.author.compareTo(other.author) > 0) {
                return 1;
            }
            if (this.author.compareTo(other.author) < 0) {
                return -1;
            }
            if (this.yearOfPublication < 0) {
                return 1;
            }
            if (this.yearOfPublication > 0) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", yearOfPublication=" + yearOfPublication +
                    "}\n";
        }
    }
}
