package no.noroff.task13;

import no.noroff.task13.movements.run;
import no.noroff.task13.movements.walk;

import java.util.Random;

public class Cow extends Herbivore implements walk, run {
    public Cow() {
        movementTypes = new String[]{"walk", "run"};
        species = "Cow";
    }

    public Cow(String name) {
        super(name);
        movementTypes = new String[]{"walk", "run"};
        species = "Cow";
    }

    @Override
    public void run() {
        System.out.println("The Cow runs happily.");
    }

    @Override
    public void walk() {
        System.out.println("The Cow walks placidly.");
    }

    @Override
    public void move() {
        int moveType = new Random().nextInt(movementTypes.length);
        listMovement();
        switch (movementTypes[moveType]) {
            case "walk":
                this.walk();
                break;
            case "run":
                this.run();
                break;
        }
    }
}
