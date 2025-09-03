package net.xonich.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo3Comparators {

    public static void main(String[] args) {

        List<Pencil> pencils = new ArrayList<>();
        pencils.add(new Pencil(Color.WHITE, 0.5));
        pencils.add(new Pencil(Color.BLACK, 7));
        pencils.add(new Pencil(Color.BLACK, 10.4));
        pencils.add(new Pencil(Color.BLUE, 5));
        pencils.add(new Pencil(Color.RED, 0.5));
        pencils.add(new Pencil(Color.GRAY, 30));

        pencils.sort(Comparator.naturalOrder());
        System.out.println(pencils);
    }

    public static class Pencil implements Comparable<Pencil> {

        private Color color;
        private double length;

        public Pencil(Color color, double length) {
            this.color = color;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Pencil{" +
                    "color=" + color +
                    ", length=" + length +
                    '}';
        }

//        @Override
//        public int compareTo(Pencil other) {
//
//            if (this.color.compareTo(other.color) > 0) { // this.color > other.color
//                return 1;
//            }
//            if (this.color.compareTo(other.color) < 0) {
//                return -1;
//            }
//            if (this.length < other.length) {
//                return 1;
//            }
//            if (this.length > other.length) {
//                return -1;
//            }
//            return 0;
//        }


        @Override
        public int compareTo(Pencil other) {

            int cmp = this.color.compareTo(other.color);
            if (cmp == 0) return Double.compare(this.length, other.length) * -1; // Double.compare(other.length, this.length)

            return cmp;
        }
    }

    public enum Color {

        WHITE,
        BLACK,
        GRAY,
        RED,
        GREEN,
        BLUE;
    }
}
