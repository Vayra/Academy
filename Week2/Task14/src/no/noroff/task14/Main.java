package no.noroff.task14;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        String baseURL = "https://anapioficeandfire.com/api/characters/";
        //URL url;
        Scanner in = new Scanner(System.in);
        String input;
        JSONObject jo;
        JSONObject house;
        JSONObject member;

        while (true)
        {
            System.out.println("Choose a character by number (q to quit):");
            input = in.next();
            if (input.equals("q")) break;
            jo = new JSONObject(requestURL(baseURL+input));


            //Print basic info
            System.out.println("Name: " + jo.get("name"));
            System.out.println("Gender: " + jo.get("gender"));
            JSONArray titles = jo.getJSONArray("titles");

            System.out.println("Titles:");
            for (Object title: titles) System.out.println(title);

            System.out.println("Allegiances:");
            JSONArray allegiances = jo.getJSONArray("allegiances");
            for (int i = 0; i < allegiances.length();i++){
                house = new JSONObject(requestURL((String)allegiances.get(i)));
                System.out.println(house.get("name"));
            }
            for (int i = 0; i < allegiances.length();i++){
                house = new JSONObject(requestURL((String)allegiances.get(i)));
                System.out.println("Do you want to list all sworn members of " + house.get("name") +"? (Y/N)");
                input = in.next();
                if (input.equals("Y")){
                    JSONArray members = house.getJSONArray("swornMembers");
                    System.out.println("Members of "+house.get("name") + ":");
                    for (Object memberSworn:members)
                    {
                        member = new JSONObject(requestURL((String)memberSworn));
                        System.out.println(member.get("name"));
                    }
                }
            }


        }
        System.out.println("PoV Characters");
        ArrayList<JSONObject> books = new ArrayList<>();
        ArrayList<String> povChars = new ArrayList<>();
        ArrayList<String> povCharNames = new ArrayList<>();

        for (int i = 1; i <13; i++){
            JSONObject book = new JSONObject(requestURL("https://anapioficeandfire.com/api/books/"+i));
            if (book.get("publisher").equals("Bantam Books"))
            {
                JSONArray chars = book.getJSONArray("povCharacters");
                for (Object ch : chars) {
                    if (!povChars.contains(ch)) {
                        povChars.add((String) ch); //Adds whole url for API call
                    }
                }
                books.add(book);
            }
        }
        String[][] grid = new String[povChars.size()][8];
        // Fill grid with empty strings instead of null.
        for (int i=0; i<povChars.size();i++)
        {
            for (int j=0; j < 8;j++)
            {
                grid[i][j] = "";
            }
        }

        for(int i = 0; i<povChars.size();i++)
        {
            JSONObject character = new JSONObject(requestURL(povChars.get(i)));
            povCharNames.add((String)character.get("name")); //get full name for easy printing later
            JSONArray povInBook = character.getJSONArray("povBooks");

            /* Book IDs:
             * 1 : A Game of Thrones
             * 2 : A Clash of Kings
             * 3 : A Storm of Swords
             * 5 : A Feast for Crows
             * 8 : A Dance With Dragons
             * 10: The Rogue Prince
             * 11: The World of Ice and Fire
             * 12: A Knight of the Seven Kingdoms
             * The last 3 do not have any PoVCharacters according to the API,
             * and will not be printed in the grid.
             */
            for (Object book:povInBook)
            {
                String[] urlSplit = ((String)book).split("/");
                int bookID = Integer.parseInt(urlSplit[urlSplit.length - 1]);
                switch (bookID)
                {
                    case 1:
                        grid[i][0] = "X";
                        break;
                    case 2:
                        grid[i][1] = "X";
                        break;
                    case 3:
                        grid[i][2] = "X";
                        break;
                    case 5:
                        grid[i][3] = "X";
                        break;
                    case 8:
                        grid[i][4] = "X";
                        break;
                    case 10:
                        grid[i][5] = "X";
                        break;
                    case 11:
                        grid[i][6] = "X";
                        break;
                    case 12:
                        grid[i][7] = "X";
                        break;
                }

            }
        }
        System.out.println("Book names:\n" +
                "* 1 : A Game of Thrones\n" +
                "* 2 : A Clash of Kings\n" +
                "* 3 : A Storm of Swords\n" +
                "* 4 : A Feast for Crows\n" +
                "* 5 : A Dance With Dragons");
        System.out.println("Book\t1\t2\t3\t4\t5\tName");
        for (int i = 0; i < povChars.size();i++) {
            System.out.println("\t\t" + grid[i][0] + "\t" + grid[i][1] + "\t" + grid[i][2] +
                    "\t" + grid[i][3] + "\t" + grid[i][4] + "\t" + povCharNames.get(i));
        }


    }

    public static String requestURL(String url) throws Exception{
        // Set URL
        URLConnection connection = new URL(url).openConnection();
        // Set property - avoid 403 (CORS)
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        // Create connection
        connection.connect();
        // Create a buffer of the input
        BufferedReader buffer  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        // Convert the response into a single string
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = buffer.readLine()) != null) {
            stringBuilder.append(line);
        }
        // return the response
        return stringBuilder.toString();
    }
}
