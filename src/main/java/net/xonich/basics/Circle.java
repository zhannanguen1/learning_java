package net.xonich.basics;

public class Circle extends Figure {

    double radius;

    public Circle(String figureName, String color, double radius) {
        super(figureName, color);
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
