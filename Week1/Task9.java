import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class Task9
{
    public static void main(String[] args)
    {
        int lines = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {
            long size = new File(args[0]).length();
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null)
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                lines++;
                line = br.readLine();
            }
            String content = sb.toString();
            Scanner in = new Scanner(System.in);
            System.out.printf("File size: %d\n", size);
            System.out.printf("# of lines: %d\n", lines);
            System.out.println("Enter keyword to search text (0 to exit)");
            String query = "";

            while (query != "0")
            {
                query = in.nextLine();
                if (query.contentEquals("0")) break;
                int n = 0;
                String[] words = content.toLowerCase().split(" ");
                for (String word:words)
                {
                    if (word.contains(query)) n++;
                }
                System.out.printf("The file contains %d instances of '%s'.\n", n, query);
            }


        } catch(Exception e)
        {
            System.out.println("Error occured\nUsage: java task9 *filename*");
            System.exit(1);
        }       
        

    }
}