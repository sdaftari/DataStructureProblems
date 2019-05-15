package Hard;


public class NQueens {
	// since board is 4*4
	final int N = 4;
	 
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
    
	public static void main(String[] args) {
		NQueens objNQueens = new NQueens();
		objNQueens.SolveNQueens();
	}
	
	boolean SolveNQueens()
	{
		int board[][] = {{0, 0, 0, 0},
	            		{0, 0, 0, 0},
	            		{0, 0, 0, 0},
	            		{0, 0, 0, 0}};
		
		if (SolveNQueensUtil(board, 0) == false)
		{
			System.out.println("No Solution");
			return false;
		}
		
		printSolution(board);
		return true;
	}
	
	boolean SolveNQueensUtil(int board[][], int col)
	{
		if (col >= N)
            return true;
		
		for (int i = 0 ; i < N; i++)
		{
			if (isSafe(board, i, col))
			{
				board[i][col] = 1;
				
				if (SolveNQueensUtil(board, col + 1) == true)
                    return true;
				
				// Backtrack
				board[i][col] = 0;
			}
		}
		
		return false;
	}
	
	boolean isSafe(int board[][], int row, int col)
	{
		int i, j;
		// At this point, column-1 queens are already placed in upper rows at first available space.
		// So we need to check all the positions along the left side only
		// check for same row along the left side
		for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
		
		//check for upper left diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
		
		//check for lower left diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        
        return true;
	}
}
