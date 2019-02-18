package no.noroff.task13;

import no.noroff.task13.movements.movement;

public abstract class Animal implements movement
{
    protected String name;
    protected String species;
    protected String[] movementTypes;
    protected String diet;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public void listMovement()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("The " + species + " can ");
        for (String type:movementTypes){
            sb.append(type + ", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(" "), " and");
        sb.append(".");
        System.out.println(sb.toString());
    }

    @Override
    public void move() {}
}