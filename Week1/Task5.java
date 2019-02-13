import java.util.ArrayList;
import java.util.Arrays;

public class Task5 
{
    public static void main(String[] args)
    {
        String search = args[0];
        String[] names = {
        "Indiana Jones",
        "Han Solo",
        "Rick Deckard",
        "Alexei Vostrikov",
        "Jack Ryan"};
        

        for (String element:names )
        {
            String out = element;
            if (element.contains(search)){ out = out + " *";}
            System.out.println(out);
        }

    }
}