package net.xonich.basics;

public class Dog extends Animal {

    String breed;

    public Dog(int eyes, int limbs, String skinType, String breed) {
        super(eyes, limbs, skinType);
        this.breed = breed;
    }

    @Override
    public void makeSound() {

        System.out.println("Woof");
    }

    public void sayName()  {
        System.out.println(breed);
    }
}
