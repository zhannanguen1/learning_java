package net.xonich.basics;

public class DemoClasses {
    public static void main(String[] args) {

        Object o = new Object();
//        MyAbstractClass m = new MyAbstractClass();

        Dog sharick = new Dog(2, 4, "Шерсть", "Корги");
        Animal chupacabra = new Animal(2, 3, "??");
        printAnimal(chupacabra);
        printAnimal(sharick);

        Animal alsoSharick = sharick;
        sharick.makeSound(); // woof
        chupacabra.makeSound(); // ???
        alsoSharick.makeSound(); // woof
        sharick.sayName();

    }

    public static void printAnimal(Animal animal) {

        System.out.println("Eyes: " + animal.eyes);
        System.out.println("Limbs: " + animal.limbs);
        System.out.println("skinType: " + animal.skinType);
    }
}
