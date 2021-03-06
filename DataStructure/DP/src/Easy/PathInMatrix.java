//Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].
//
//1. Matrix[r+1][c]
//
//2. Matrix[r+1][c-1]
//
//3. Matrix[r+1][c+1]
//
//Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
//Time Complexity: O(N*M)

package Easy;

public class PathInMatrix {

	// Function to calculate max path in matrix 
    static int findMaxPath(int mat[][]) 
    { 
    	int M = mat.length; int N = mat[0].length;
        // To find max val in first row 
        int res = -1; 
        for (int i = 0; i < N; i++) 
            res = Math.max(res, mat[0][i]); 
  
        for (int i = 1; i < M; i++)  
        { 
            res = -1; 
            for (int j = 0; j < N; j++)  
            { 
                // When all paths are possible 
                if (j > 0 && j < N - 1) 
                    mat[i][j] += Math.max(mat[i - 1][j], Math.max(mat[i - 1][j - 1], mat[i - 1][j + 1])); 
  
                // When diagonal right is not possible 
                else if (j > 0) 
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j - 1]); 
  
                // When diagonal left is not possible 
                else if (j < N - 1) 
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j + 1]); 
  
                // Store max path sum 
                res = Math.max(mat[i][j], res); 
            } 
        } 
        return res; 
    } 
    
    public static void main(String[] args) {
    	int mat[][] = {{348, 391}, {618, 193}};
    	System.out.println(findMaxPath(mat));
	}
}
