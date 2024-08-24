package net.xonich.basics;

public class Animal {

    int eyes;
    int limbs;
    String skinType;

    public Animal(int eyes, int limbs, String skinType) {
        this.eyes = eyes;
        this.limbs = limbs;
        this.skinType = skinType;
    }

    public void makeSound() {

        System.out.println("???");
    }
}
