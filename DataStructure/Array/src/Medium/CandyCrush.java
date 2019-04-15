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
