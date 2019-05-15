//Example:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.

// Time: 

package Medium;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { {'A','B','C','E'},
				     	   {'S','F','C','S'},
				     	   {'A','D','E','E'}};
		String word = "ABCCE";
		WordSearch obj = new WordSearch();
		System.out.println(obj.exist(board, word));
	}
	
	public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) 
        {
            for (int y = 0; y < board[x].length; y++) 
            {
                if (exists(board, x, y, w, 0)) 
                    return true;
            }
	    }
	    return false;                                                           
    }
    
    private boolean exists(char[][] board, int x, int y, char[] word, int i)
    {
        if (i == word.length)
            return true;
        
        if (x < 0 || x == board.length || y < 0 || y == board[x].length)
            return false;
        
        if (board[x][y] != word[i]) 
            return false;
	    board[x][y] ^= 256;
        
        boolean ex = exists(board, x+1, y, word, i+1) || exists(board, x-1, y, word, i+1)
            || exists(board, x, y+1, word, i+1) || exists(board, x, y-1, word, i+1);
        
        board[x][y] ^= 256;
	    return ex;
    }

}
