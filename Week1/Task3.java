import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        int height = new Integer(args[0]);
        
        String horizontal = new String(new char[height]).replace("\0", "#");
        String vertical = "#" + new String(new char[height-2]).replace("\0", " ") + "#";
        System.out.println(horizontal);
        for (int i = 1; i < height-1; i++)
        {
            System.out.println(vertical);
        }
        System.out.println(horizontal);
    }
}