package no.noroff.task13;

public abstract class Carnivore extends Animal
{
    public Carnivore() {
        diet = "Carnivore";
    }

    public Carnivore(String species) {
        super(species);
        diet = "Carnivore";

    }
}