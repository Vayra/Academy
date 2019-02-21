package no.noroff.task15;

public class PetRock {
    private String name;
    private boolean happy = false;

    public PetRock(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("No name provided");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String printHappyMessage(){
        if (!happy){
            throw new IllegalStateException("Not happy!");
        }
        //System.out.println("I'm happy!");
        return "I'm happy!";
    }

    public int getFavNumber(){
        return 42;
    }

    public void waitTillHappy(){
        while(!happy){
            playWithRock();
        }
    }
}
