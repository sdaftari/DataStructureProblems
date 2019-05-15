//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

package Hard;

public class IsValidSudoku {
	
	public boolean isValidSudoku(char[][] board) 
	{
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// check all columns for each row
		for (int i = 0; i < 9; i++) 
		{
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) 
			{
				if (board[i][j] != '.') 
				{
					// If the number from the grid is already visited (alread true)
					if (m[(int) (board[i][j] - '1')]) 
						return false;
					// Otherwise make it true
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	 
		//check all rows for each column
		for (int j = 0; j < 9; j++) 
		{
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) 
			{
				if (board[i][j] != '.') 
				{
					if (m[(int) (board[i][j] - '1')]) 
						return false;
					
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	 
		//check each 3*3 matrix
		for (int block = 0; block < 9; block++) 
		{
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) 
			{
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) 
				{
					if (board[i][j] != '.') 
					{
						if (m[(int) (board[i][j] - '1')]) 
							return false;
						
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
	 
		return true;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
