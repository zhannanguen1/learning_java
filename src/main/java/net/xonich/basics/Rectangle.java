package net.xonich.basics;

public class Rectangle extends Figure {

    double sideLength;
    double sideWidth;

    public Rectangle(String figureName, String color, double sideLength, double sideWidth) {
        super(figureName, color);
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
