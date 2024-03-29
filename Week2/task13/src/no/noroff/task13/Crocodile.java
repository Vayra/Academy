package no.noroff.task13;
import no.noroff.task13.movements.run;
import no.noroff.task13.movements.swim;
import no.noroff.task13.movements.walk;

import java.util.Random;

public class Crocodile extends Carnivore implements walk, swim, run {
    public Crocodile() {
        species = "Crocodile";
        movementTypes = new String[]{"walk", "swim", "run"};
    }

    public Crocodile(String name) {
        super(name);
        movementTypes = new String[]{"walk", "swim", "run"};
        species = "Crocodile";
    }

    @Override
    public void run() {
        System.out.println("The Crocodile runs like the wind!");
    }

    @Override
    public void swim() {
        System.out.println("The Crocodile swims scarily!");
    }

    @Override
    public void walk() {
        System.out.println("The Crocodile walks menacingly!");
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
            case "swim":
                this.swim();
                break;
        }
    }
}
