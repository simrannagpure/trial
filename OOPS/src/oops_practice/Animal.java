package oops_practice;

import java.util.jar.Manifest;

public class Animal{
    double legs;
    double brainSize;
    Animal(double legs, double brainSize){
        this.legs = legs;
        this.brainSize = brainSize;
    }

    public void sound() {
        System.out.println("Which animal sound you want ?");
    }
}
class Lion extends Animal{

    Lion(double legs, double brainSize) {
        super(legs, brainSize);
    }
    @Override
    public void sound(){
        System.out.println("Lion roar!! roar! roar!!");
    }
}
class Elephant extends Animal{

    Elephant(double legs, double brainSize) {
        super(legs, brainSize);
    }
    @Override
    public void sound(){
        System.out.println("Goat baa! baa! baa!");
    }
}
class Cow extends Animal{

    Cow(double legs, double brainSize) {
        super(legs, brainSize);
    }
    @Override
    public void sound(){
        System.out.println("Cow moo moo");
    }
}
class Goat extends Animal{

    Goat(double legs, double brainSize) {
        super(legs, brainSize);
    }
    @Override
    public void sound(){
        System.out.println("Elephant Pawoo! Pawoo!");
    }
}
class Main2{
    public static void main(String[] args) {
        Lion l1 = new Lion(2, 0.5);
        l1.sound();
    }
}
