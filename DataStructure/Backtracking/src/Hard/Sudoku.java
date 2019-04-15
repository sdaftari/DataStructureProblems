/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
 */
package Hard;

public class Sudoku {
	public void solveSudoku(char[][] board) 
	{
		if(board == null || board.length == 0)
            return;
        solve(board);
	}
	
	public boolean solve(char[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
            for(int j = 0; j < board[0].length; j++)
	        {
            	// if cell is empty
            	if(board[i][j] == '.')
            	{
            		//trial. Try 1 through 9
            		for(char c = '1'; c <= '9'; c++)
            		{
            			if(isValid(board, i, j, c))
            			{
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
            			}
            		}
            	}
	 
	            return false;
	        }
	    }
	 
	    return true; // does not matter
	}
	
	public boolean isValid(char[][] board, int row, int col, char c)
	{
		for(int i = 0; i < 9; i++)
		{
			//check row
			if(board[i][col] != '.' && board[i][col] == c) 
				return false; 
			
			//check column
			if(board[row][i] != '.' && board[row][i] == c) 
				return false;
			
			//check 3*3 block
			if(board[3 * (row/3) + i/3][3 * (col/3) + i % 3] != '.' && board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c) 
				return false; 
		}
	 
	    return true;
	}
}
