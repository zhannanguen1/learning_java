package net.xonich.basics;

public class Triangle extends Figure {

    private final double triangleSideOne;
    private final double triangleSideTwo;
    private final double triangleSideThree;

    public Triangle(String color, double triangleSideOne, double triangleSideTwo, double triangleSideThree) {
        super("Треугольник", color);
        this.triangleSideOne = triangleSideOne;
        this.triangleSideTwo = triangleSideTwo;
        this.triangleSideThree = triangleSideThree;
    }

    @Override
    public double getArea() {
        double semiPerimeter = (triangleSideOne + triangleSideTwo + triangleSideThree) / 2;
        return
                Math.sqrt(semiPerimeter
                        * (semiPerimeter - triangleSideOne)
                        * (semiPerimeter - triangleSideTwo)
                        * (semiPerimeter - triangleSideThree));
    }

    @Override
    public double getPerimeter() {
        return triangleSideOne + triangleSideTwo + triangleSideThree;
    }
}
