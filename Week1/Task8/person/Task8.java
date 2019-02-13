package person;

import java.util.ArrayList;
import java.util.Arrays;


public class Task8 
{
    public static void main(String[] args)
    {
        String search = args[0];
        ArrayList<Person> names = new ArrayList<Person>();
        names.add(new Person("Indiana", "Jones"))x;
        names.add(new Person("Han", "Solo"));
        names.add(new Person("Rick", "Deckard"));
        names.add(new Person("Alexei", "Vostrikov"));
        names.add(new Person("Jack", "Ryan"));
        /*{
        "Indiana Jones",
        "Han Solo",
        "Rick Deckard",
        "Alexei Vostrikov",
        "Jack Ryan"};*/
        

        for (Person element:names )
        {
            String out = element.getName();
            if (element.contains(search)){ out = out + " *";}
            System.out.println(out);
        }

    }
}