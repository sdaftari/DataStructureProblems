//If a mine ('M') is revealed, then the game is over - change it to 'X'.
//If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.

package Medium;

public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        // If we click on M, change it to X and game is over
        if (board[row][col] == 'M') 
        {
            // Mine
            board[row][col] = 'X';
        }
        else
        {
            // Empty
            // Count the number of mines around the 8 cells of {row, col}
            int count = 0;
            for (int i = -1; i < 2; i++) 
            {
                for (int j = -1; j < 2; j++) 
                {
                    if (i == 0 && j == 0) 
                        continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) 
                        continue;
                    // If any of M or X is found, increment the count
                    if (board[r][c] == 'M' || board[r][c] == 'X') 
                        count++;
                }
            }
            
            // If the count is greater than 0, update it at that click position
            if (count > 0) 
            { 
                // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
            }
            else
            {
                // Continue DFS to adjacent cells.
            	// Otherwise make it as 'B' and find all the adjacent once
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) 
                {
                    for (int j = -1; j < 2; j++) 
                    {
                        if (i == 0 && j == 0) 
                            continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) 
                            continue;
                        if (board[r][c] == 'E') 
                            updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }
        
        return board;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
