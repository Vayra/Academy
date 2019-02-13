package person;

import java.util.ArrayList;
import java.util.Arrays;


public class Task8 
{
    public static void main(String[] args)
    {
        String search = args[0];
        ArrayList<Person> names = new ArrayList<Person>();
        names.add(new Person("Indiana", "Jones", "0800-313-5134"));
        names.add(new Person("Han", "Solo", "0133-135-3533"));
        names.add(new Person("Rick", "Deckard", "0135-315-5424"));
        names.add(new Person("Alexei", "Vostrikov", "519-135-3513"));
        names.add(new Person("Jack", "Ryan", "135-354-1343"));
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