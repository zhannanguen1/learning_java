package net.xonich.multithreading;

import java.util.concurrent.atomic.AtomicReference;

public class Point {

    private static class Coordinates {

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

    public void translate(double dx, double dy) {

        Coordinates current = null;
        Coordinates newCoordinates = null;

        while (!coordinates.compareAndSet(current, newCoordinates)) {
            current = coordinates.get();
            newCoordinates = new Coordinates(current.x + dx, current.y + dy);
        }
    }

    @Override
    public String toString() {
        Coordinates coords = coordinates.get();
        return "Point(" + coords.x + ", " + coords.y + ")";
    }
}
