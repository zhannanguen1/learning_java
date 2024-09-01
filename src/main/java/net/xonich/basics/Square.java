package net.xonich.basics;

public class Square extends Figure {

    double sideLength;

    public Square(String color, double sideLength) {
        super("Квадрат", color);
        if (sideLength <= 0) {
            throw new IllegalArgumentException("...");
        }
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }
}
