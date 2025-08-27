package net.xonich.problems;

public class Performance {

    @FunctionalInterface
    public interface MeasurableAction {
        void execute();
    }

    public static void measureTime(MeasurableAction action) {

        long startTime = System.nanoTime();
        action.execute();
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000.0 + " мс");
    }

    public static void main(String[] args) {

        measureTime(() -> {
            long sum = 0;
            for (int i = 0; i < 1_000_000; i++) {
                sum += i;
            }
            System.out.println("Сумма: " + sum);
        });
    }
}
