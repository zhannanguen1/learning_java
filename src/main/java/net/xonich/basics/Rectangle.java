package net.xonich.basics;

public class Rectangle extends Figure {

    private final double sideLength;
    private final double sideWidth;

    public Rectangle(String color, double sideLength, double sideWidth) {
        super("Прямоугольник", color);
        this.sideLength = sideLength;
        this.sideWidth = sideWidth;
    }

    @Override
    public double getArea() {
        return sideLength * sideWidth;
    }

    @Override
    public double getPerimeter() {
        return (sideLength + sideWidth) * 2;
    }
}
