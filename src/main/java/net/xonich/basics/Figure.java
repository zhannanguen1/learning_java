package net.xonich.basics;

public abstract class Figure {

    private final String figureName;
    private final String color;

    public Figure(String figureName, String color) {
        this.figureName = figureName;
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getFigureName() {
        return figureName;
    }

    public String getColor() {
        return color;
    }
}
