package net.xonich.basics;

public class DemoClasses {
    public static void main(String[] args) {

//        Object o = new Object();
////        MyAbstractClass m = new MyAbstractClass();
//
//        Dog sharick = new Dog(2, 4, "Шерсть", "Корги");
//        Animal chupacabra = new Animal(2, 3, "??");
//        printAnimal(chupacabra);
//        printAnimal(sharick);
//
//        Animal alsoSharick = sharick;
//        sharick.makeSound(); // woof
//        chupacabra.makeSound(); // ???
//        alsoSharick.makeSound(); // woof
//        sharick.sayName();

        Square square = new Square("red", 2);
//        Square square2 = new Square("red", 3);
//        square.figureName = "Круг";
        square.getArea();
        square.getPerimeter();

        Rectangle rectangle = new Rectangle("Прямоугольник","green", 4, 7);
        rectangle.getArea();
        rectangle.getPerimeter();

        Triangle triangle = new Triangle("Треугольник","yellow", 20, 18, 9);
        triangle.getArea();
        triangle.getPerimeter();

        Circle circle = new Circle("Круг","pink", 2.4);
        circle.getArea();
        circle.getPerimeter();
    }

    public static void printAnimal(Animal animal) {

        System.out.println("Eyes: " + animal.eyes);
        System.out.println("Limbs: " + animal.limbs);
        System.out.println("skinType: " + animal.skinType);
    }
}
