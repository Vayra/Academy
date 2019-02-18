package no.noroff.task13;

import no.noroff.task13.movements.fly;
import no.noroff.task13.movements.walk;

import java.util.Random;

public class Raven extends Omnivore implements fly, walk {
    public Raven() {
        movementTypes = new String[]{"walk", "fly"};
        species = "Raven";
    }

    public Raven(String name) {
        super(name);
        species = "Raven";
        movementTypes = new String[]{"walk", "fly"};
    }


    public void fly() {
        System.out.println("The Raven flies across the sky.");
    }


    public void walk() {
        System.out.println("The Raven walks in search of food.");
    }

    @Override
    public void move() {
        int moveType = new Random().nextInt(movementTypes.length);
        listMovement();
        switch (movementTypes[moveType]) {
            case "walk":
                this.walk();
                break;
            case "fly":
                this.fly();
                break;
        }
    }
}
