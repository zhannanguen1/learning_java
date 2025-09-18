package net.xonich.function;

import java.util.Arrays;
import java.util.Comparator;

public class Demo5Comparator {

    public static void comparatorUsage(String[] args) {

        Integer[] ints = {1, -13, 1999, -3, 22, -15, 15, 14, 5, 3, 0};

        Comparator<Integer> cmp1 = (lhs, rhs) -> {
            if (Math.abs(lhs) > Math.abs(rhs)) {
                return 1;
            }
            if (Math.abs(lhs) < Math.abs(rhs)) {
                return -1;
            }
            return 0;
        };

        Comparator<Integer> cmp2 = (lhs, rhs) -> {

            return Integer.compare(Math.abs(lhs), Math.abs(rhs));
        };

        Comparator<Integer> cmp3 = Comparator.comparing(Math::abs);


        Arrays.sort(ints, cmp2);
        System.out.println(Arrays.toString(ints));


    }

    public static <T> void sort(T[] arr, MyComparator<T> cmp) {

        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr.length - j; i++) {
                System.out.println(Arrays.toString(arr));
                if (cmp.compare(arr[i - 1], arr[i]) > 0) {
                    swap(arr, i, i - 1);
                }
            }
        }
    }

    // [1, 2, 3, 4] -> [3, 2, 1, 4]
    public static <T> void swap(T[] arr, int i, int j) {

        T x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }

    public static void main(String[] args) {

        Integer[] ints = {1, -13, 1999, -3, 22, -15, 15, 14, 5, 3, 0};

        sort(ints, MyComparator.naturalOrder());

        System.out.println(Arrays.toString(ints));
    }

    public interface MyComparator<T> {

        public int compare(T lhs, T rhs);

        public static <T extends Comparable<? super T>> MyComparator<T> naturalOrder() {

            MyComparator<T> myComparator = new MyComparator<T>() {
                @Override
                public int compare(T lhs, T rhs) {
                    if (lhs == null && rhs == null) return 0;
                    if (lhs == null) return -1;
                    if (rhs == null) return 1;

                    return lhs.compareTo(rhs);
                }
            };
            return myComparator;
        }

        public static <T extends Comparable<? super T>> MyComparator<T> reverseOrder() {

            MyComparator<T> myComparator = new MyComparator<T>() {
                @Override
                public int compare(T lhs, T rhs) {
                    if (lhs == null && rhs == null) return 0;
                    if (lhs == null) return 1;
                    if (rhs == null) return -1;

                    return rhs.compareTo(lhs);
                }
            };
            return myComparator;
        }
    }
}
