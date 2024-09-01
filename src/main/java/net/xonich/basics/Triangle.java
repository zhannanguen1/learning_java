package net.xonich.basics;

public class Triangle extends Figure {

    double triangleSideOne;
    double triangleSideTwo;
    double triangleSideThree;

    public Triangle(String figureName, String color, double triangleSideOne, double triangleSideTwo, double triangleSideThree) {
        super(figureName, color);
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
