import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Hello there, what is your name?");
        String name = in.nextLine();
        System.out.printf("Hello there %s, nice to meet you!", name);
        in.close();
    }

}