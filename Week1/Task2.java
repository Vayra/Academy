public class Task2
{
    public static void main(String[] args)
    {
        if (args.length < 1) {
            System.out.println("ERROR: Expected at least 1 keyword argument. \nPlease run the program like this:\njava Task2 args");
        }
        else {
            System.out.printf("Hello %s, your name is %d characters long ,and starts with a(n) %s", args[0], args[0].length(), args[0].charAt(0));
        }
    }
}