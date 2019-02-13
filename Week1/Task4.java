public class Task4
{
    public static void main(String[] args)
    {
        int height = new Integer(args[0]);
        int width = new Integer(args[1]);
        
        String horizontal = new String(new char[width]).replace("\0", "#");
        String verticalBlank = "#" + new String(new char[width-2]).replace("\0", " ") + "#";
        String verticalInner = "# #" + new String(new char[width-6]).replace("\0", " ") + "# #";
        String horizontalInner = "# " + new String(new char[width-4]).replace("\0", "#") + " #";
        System.out.println(horizontal);
        System.out.println(verticalBlank);
        System.out.println(horizontalInner);
        for (int i = 1; i < height-5; i++)
        {
            System.out.println(verticalInner);
        }
        System.out.println(horizontalInner);
        System.out.println(verticalBlank);
        System.out.println(horizontal);
    }
}