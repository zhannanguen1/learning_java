package net.xonich.function;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Demo8 {

    public static void reduce(String[] args) {

        long range = IntStream.range(1, 10).mapToLong(x -> (long) x).reduce(1L, (lhs, rhs) -> lhs * rhs);
        BigDecimal reduce = IntStream.range(1, 100).mapToObj(BigDecimal::valueOf).reduce(BigDecimal.ONE, BigDecimal::multiply);


        System.out.println("range = " + range);
        System.out.println("reduce = " + reduce);

        class Product {

            String name;
            BigDecimal price;
        }

        List<Product> productList = new ArrayList<>();

    }

    public static void mainOptional(String[] args) {

        Optional<String> optionalS = Optional.of("foo");
        Optional<String> optionalS1 = Optional.ofNullable("foo"); // использ, когда не знаю, нужны ли Null
        Optional<String> empty = Optional.empty();

        empty.ifPresent(System.out::println);
//        optionalS.ifPresentOrElse(System.out::println, () -> System.out.println("Optional is empty"));

//        empty.get();
        if (empty.isPresent()) {
            System.out.println(empty.get());
        }

        String stringS = optionalS.orElse(getBar());
        System.out.println(stringS);

        String orElseGet = optionalS.orElseGet(() -> getBar());
        System.out.println(orElseGet);
    }

    private static String getBar() {

        return "bar";
    }

    public static void main(String[] args) throws InterruptedException {

        Optional<BigDecimal> balanceFromCache = getBalanceFromCache();
//        if (balanceFromCache.isPresent()) {
//            System.out.println(balanceFromCache.get());
//        } else {
//            System.out.println(getBalanceFromDB());
//        }

//        System.out.println(balanceFromCache.orElse(getBalanceFromDB()));
        System.out.println(balanceFromCache.orElseGet(() -> getBalanceFromDB()));
    }

    public static Optional<BigDecimal> getBalanceFromCache() {

        if (Math.random() > 0.5) {
            System.out.println("returning value from cache");
            return Optional.of(BigDecimal.valueOf(1_000_000));
        } else {
            return Optional.empty();
        }
    }

    private static BigDecimal getBalanceFromDB()  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("returning value from DB");
        return BigDecimal.valueOf(2_000_000);
    }
}
