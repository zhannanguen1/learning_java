package net.xonich.basics;

public class Circle extends Figure {

    private final double radius;

    public Circle(String color, double radius) {
        super("Круг", color);
        this.radius = radius;
    }

    @Override
    public double getArea() {

        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {

        return  2 * Math.PI * radius;
    }
}
