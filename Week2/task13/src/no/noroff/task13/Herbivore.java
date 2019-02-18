package no.noroff.task13;

public class Herbivore extends Animal
{
    public Herbivore() {
        diet = "Herbivore";

    }

    public Herbivore(String species) {
        super(species);
        diet = "Herbivore";

    }
}