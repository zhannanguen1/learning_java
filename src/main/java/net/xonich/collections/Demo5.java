package net.xonich.collections;

import java.math.BigDecimal;

public class Demo5 {

    public static double compoundInterest(double initial, double interest, double time) {

        return initial * Math.exp(interest * time);
    }

    private static <T extends Number> double compoundInterestGeneric(T initial, T interest, T time) {

        return initial.doubleValue() * Math.exp(interest.doubleValue() * time.doubleValue());
    }

    public static void main(String[] args) {

        System.out.println("compoundInterest(100, 0.1, 1) = " + compoundInterest(100, 0.1, 1));
        System.out.println("compoundInterestGeneric(100, 0.1, 1) = " + compoundInterestGeneric(100, 0.1, 1));
        System.out.println("compoundInterestGeneric(100, 0.1, 1) = " + compoundInterestGeneric(new BigDecimal(100), new BigDecimal("0.1"), BigDecimal.ONE));
//        System.out.println("compoundInterestGeneric(100, 0.1, 1) = " + compoundInterestGeneric("100", "0.1", "1"));

        System.out.println(0.2);
    }
}
