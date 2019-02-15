package task11;

import task11.EightQueens;

public class Task11
{
    public static void main(String[] args)
    {
        int[] start = decodeNotation(args[0]);
        EightQueens problem = new EightQueens(8, start[1],start[0] ); // remember board positions index from 0, not 1.
        boolean solution = problem.solve();
        if (solution)
        {
            System.out.println("Solution found!");
            problem.board.printBoard();
        }
        else System.out.println("No solution found! :(");
    }

    public static int[] decodeNotation(String start)
    {
        if (start.length() != 2 || start.charAt(0) > 72 || start.charAt(0) < 65 || start.charAt(1) >57 || start.charAt(1) < 49)
        {
            System.out.println("Invalid format, please use Algebraic notation, ex A4, or B8");
            System.exit(1);
        }
        int[] decoded = new int[]{0,0};
        decoded[0] = start.charAt(0)-65;
        decoded[1] = Integer.parseInt(start.substring(1))-1;
        
        
        return decoded;
    }
}