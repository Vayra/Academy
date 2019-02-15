package task11;

public class Board
{
    int sideLen;
    String[][] board;

    public Board()
    {
       this(8);
    }

    public Board(int side)
    {
        sideLen = side;
        board = new String[sideLen][sideLen];
        clearBoard();

    }

    public void clearBoard()
    {
        for (int i = 0; i < sideLen; i++)
        {
            for (int j = 0; j < sideLen; j++)
            {
                board[i][j] = ".";
            }
        }
    }
    /**
     * Place a queen and check if position is valid
     * @param rank
     * @param file
     * @return true if position is possible, false if not
     */
    

    public boolean placeQueen(int rank, int file)
    {
        if (board[rank][file].equals("."))
        {
            board[rank][file] = "Q";
            if (canAttack(rank, file)){
                board[rank][file] = ".";

                return false;
            }
            return true;
        } else
        {
            return false;
        }

    }

    public void removeQueen(int rank, int file)
    {
        board[rank][file] = ".";
    }

    /**
     * Check if any queen can attack another
     * @return true if any queen can attack
     */
    private boolean canAttack(int rank, int file)
    {
        //Vertical
        for (int i = 0; i < sideLen; i++)
        {
            if (i != rank){
                if (board[i][file].equals("Q")){return true;} //Found another queen
            }
        }
        //Horizontal
        for (int i = 0; i < sideLen; i++)
        {
            if (i != file){
                if (board[rank][i].equals("Q")){return true;} //Found another queen
            }
        }
        //Rising Diagonal
        for (int i = 0-sideLen; i <sideLen; i++)
        {
            if (rank+i >= 0 && rank+i <= 7 && file+i >= 0 && file+i <= 7)
            {
                if (board[rank+i][file+i].equals("Q") && i != 0) {return true;}
            }
        }
        //Descending diagonal
        for (int i = 0-sideLen; i <sideLen; i++)
        {
            if (rank-i >= 0 && rank-i <= 7 && file+i >= 0 && file+i <= 7)
            {
                if (board[rank-i][file+i].equals("Q") && i != 0) {return true;}
            }
        }
        return false;
    }

    /**
     * Prints the board state
     */
    public void printBoard()
    {
        System.out.println("Board state:");
        System.out.println("  A B C D E F G H");
        for (int i = sideLen-1; i>=0;i--)
        {
            System.out.print(i+1 + " ");
            for (int j = 0; j<sideLen;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.print(" " + (i+1) + "\n");
        }
        System.out.println("  A B C D E F G H");
    }
}