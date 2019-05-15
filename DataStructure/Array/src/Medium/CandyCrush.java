//Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) 
//is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
//If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
//After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop 
// outside the top boundary.)
//After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
//If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
//You need to perform the above rules until the board becomes stable, then return the current board.

package Medium;

public class CandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] candyCrush(int[][] board) 
    {
        int N = board.length, M = board[0].length;
        boolean found = true;
        while (found) 
        {
            found = false;
            // Negate the values if we found three horizontal and vertical same values
            for (int i = 0; i < N; i++) 
            {
                for (int j = 0; j < M; j++) 
                {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) 
                        continue;
                    // If right two values are equal
                    if (j < M - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) 
                    {
                        found = true;
                        int ind = j;
                        // Negate the value for all columns having same value
                        while (ind < M && Math.abs(board[i][ind]) == val) 
                            board[i][ind++] = -val;
                    }
                    
                    // If bottom two values are equal
                    if (i < N - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) 
                    {
                        found = true;
                        int ind = i;
                        // Negate the value for all rows having same value
                        while (ind < N && Math.abs(board[ind][j]) == val) 
                            board[ind++][j] = -val;           
                    }
                }
            }
            if (found) 
            { 
                // For each column
                for (int j = 0; j < M; j++) 
                {
                    int storeInd = N - 1;
                    // For each row in that column, starting from last row
                    for (int i = N - 1; i >= 0; i--) 
                    {
                        // Slide the non negative and non-zero value below
                        if (board[i][j] > 0) 
                            board[storeInd--][j] = board[i][j];
                    }
                    // And for rest of the rows in that column, make it 0
                    for (int k = storeInd; k >= 0; k--) 
                        board[k][j] = 0;
                }
            }
        }
        return board;
    }
}
