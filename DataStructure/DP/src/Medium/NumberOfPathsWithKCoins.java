//Input:  k = 12
//        mat[][] = { {1, 2, 3},
//                    {4, 6, 5},
//                    {3, 2, 1}
//                  };
//Output:  2
//There are two paths with 12 coins
//1 -> 2 -> 6 -> 2 -> 1
//1 -> 2 -> 3 -> 5 -> 1
// Time: Time complexity of this solution is O(m*n*k).

package Medium;

public class NumberOfPathsWithKCoins {
	static final int R = 3; 
    static final int C = 3; 
    static final int MAX_K = 100; 
    
    static int [][][]dp=new int[R][C][MAX_K]; 
    
	static int pathCountDPRecDP(int [][]mat, int m, int n, int k) 
    { 
        // Base cases 
        if (m < 0 || n < 0) return 0; 
        if (m==0 && n==0) return (k == mat[m][n] ? 1 : 0); 
      
        // If this subproblem is already solved 
        if (dp[m][n][k] != -1) return dp[m][n][k]; 
      
        // (m, n) can be reached either through (m-1, n) or 
        // through (m, n-1) 
        dp[m][n][k] = pathCountDPRecDP(mat, m-1, n, k-mat[m][n]) + 
                    pathCountDPRecDP(mat, m, n-1, k-mat[m][n]); 
      
        return dp[m][n][k]; 
    } 
      
    // This function mainly initializes dp[][][] and calls 
    // pathCountDPRecDP() 
    static int pathCountDP(int [][]mat, int k) 
    { 
        for(int i=0;i<R;i++) 
            for(int j=0;j<C;j++) 
                for(int l=0;l<MAX_K;l++) 
                  dp[i][j][l]=-1; 
                    
        return pathCountDPRecDP(mat, R-1, C-1, k); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
