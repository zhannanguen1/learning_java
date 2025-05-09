package net.xonich.multithreading;

import java.util.concurrent.atomic.AtomicReference;

public class Point {

    private static final class Coordinates {
        private final double x;
        private final double y;

        public Coordinates(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private final AtomicReference<Coordinates> coordinates;

    public Point(double x, double y) {

        this.coordinates = new AtomicReference<>(new Coordinates(x, y));
    }

    public double getX() {
        return coordinates.get().x;
    }

    public double getY() {
        return coordinates.get().y;
    }

    public void translate(double dx, double dy) {

        Coordinates current;
        Coordinates newCoordinates;

        do {
            current = coordinates.get(); // получаем текущие координаты
            newCoordinates = new Coordinates(current.x + dx, current.y + dy); // Вычисляем новые координаты
        } while (!coordinates.compareAndSet(current, newCoordinates));
//        coordinates.set(newCoordinates);
        // Если другой поток еще не изменил координаты, то CAS выполняется и цикл завершается.
        // Если данные изменены, то compareAndSet вернет false и цикл повторится

    }
}
