// O(m+n) 

package Medium;

public class RowWithMax1s {

	public static void main(String[] args) {
		int[][] mat = { {0, 0, 0, 1},
	        {0, 1, 1, 1},
	        {1, 1, 1, 1},
	        {0, 0, 0, 0}
	    };
		System.out.println(rowWithMax1s(mat));
	}

	// The main function that returns index of row with maximum number of 1s.
	static int rowWithMax1s(int[][] mat)
	{
		int R = mat.length;
		int C = mat[0].length;
	    // Initialize first row as row with max 1s
	    int max_row_index = 0;
	 
	    // Get the index of first 1 in row 0.
	    // Use this index to initialize the index of leftmost 1 seen so far
	    int j = -1;
	    for (int col = 0; col < C; col++)
	    {
	    	if (mat[0][col] == 1)
	    	{
	    		j = col;
	    		break;
	    	}
	    }	    
	    
	    if (j == -1) // if 1 is not present in first row
	      j = C - 1;
	 
	    for (int i = 1; i < R; i++)
	    {
	        // Move left until a 0 is found
	        while (j >= 0 && mat[i][j] == 1)
	        {
	           j = j-1;  // Update the index of leftmost 1 seen so far
	           max_row_index = i;  // Update max_row_index
	        }
	    }
	    return max_row_index;
	}
}
