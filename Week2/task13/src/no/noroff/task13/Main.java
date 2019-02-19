package no.noroff.task13;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Crocodile animal1 = new Crocodile("Schnappi");
        Cow animal2 = new Cow("Litago");
        Raven animal3 = new Raven("Huginn");
        Raven animal4 = new Raven("Muninn");
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        for (Animal animal:animals)
        {
            animal.move();
        }

    }
}
