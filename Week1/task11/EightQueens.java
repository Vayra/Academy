package task11;

public class EightQueens
{
    Board board;
    int startFile, size;

    public EightQueens(int size,int startRank,int startFile)
    {
        board = new Board(size);
        this.size = size;
        this.startFile = startFile;
        
        board.placeQueen(startRank, startFile);
        //board.printBoard();
    }

    public boolean solve(){return solve(0, startFile);}
    /**
     * 
     * @param file current file
     * @param fixedFile File of the input queen
     * @return true if solution is found
     */
    public boolean solve(int file, int fixedFile)
    {
        if (file >= size){
            return true; //Solved
        }

        // Try to place queen in each rank in current file
        if (file == fixedFile) {if (solve(file+1, fixedFile)) return true;}
        else
        {
            for (int i = 0; i < size; i++)
            {
                if (board.placeQueen(i, file)){
                    if (solve(file+1, fixedFile)) return true;
                }
                board.removeQueen(i, file);
            }
        }
        return false;
        
    }
}