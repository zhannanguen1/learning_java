package net.xonich.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Demo6 {

    public static void main_contrvar(String[] args) {

        String[] strings = new String[10];
        strings[0] = "qwe";
        Object[] objects = strings;
        objects[1] = 42; // во время исполнения появилась ArrayStoreException

        List<String> strs = new ArrayList<>();
        strs.add("asd");
//        List<Object> objs = strs; // такое не пропустит компилятор

        Integer i = 42;
        Long l = 11L;
        Number n = l; //Long является подклассом Number. Поэтому этот вариант норм

//        List<Number> numbers = new ArrayList<Integer>(); // Дженерики не ковариантны
        Number[] numArr = new Integer[10]; // создать такой массив можно, но добавить туда что-то помимо Integer нельзя
    }

    public static void main_PECS(String[] args) {

        List<? extends Number> numbers = new ArrayList<Integer>();
//        numbers.add(42);
//        Number number = numbers.get(0);

        List<? super Number> nums = new ArrayList<Number>();
        nums.add(42);
        nums.add(new BigDecimal(123));
//        Integer object = nums.get(0);

        List<Number> wallet = new ArrayList<>();
        addMoneyToWallet(wallet, 42);
        addMoneyToWallet(wallet, 3.3);
        printWalletContent(wallet);

        List<Double> wallet2 = new ArrayList<>();
        wallet.addAll(wallet2);
    }

    public static void main(String[] args) {

        MyArrayList<Number> w1 = new MyArrayList<>();
        w1.add(42);
        w1.add(3);

        MyArrayList<Double> w2 = new MyArrayList<>();
        w1.addAll(w2);
    }

//    public static <T extends Number> void addMoneyToWallet(List<T> wallet, T sum) {
//
//        wallet.add(sum);
//    }

    public static void addMoneyToWallet(List<? super Number> wallet, Number sum) {
        wallet.add(sum);
    }

    public static void printWalletContent(List<? extends Number> wallet) {

        for (Number number : wallet) {
            System.out.println(number);
        }
    }

}
