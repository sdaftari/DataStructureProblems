//Example 1:
//Input: [5,3,4,5]
//Output: true
//Explanation: 
//Alex starts first, and can only take the first 5 or the last 5.
//Say he takes the first 5, so that the row becomes [3, 4, 5].
//If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
//If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
//This demonstrated that taking the first 5 was a winning move for Alex, so we return true.

// Optimal Strategy
//Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. 
//In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. 
//Determine the maximum possible amount of money we can definitely win if we move first.
//Note: The opponent is as clever as the user.
//1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
//2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)

package Extra;
import java.util.*;

public class StoneGame {
	public boolean stoneGame(int[] piles) 
	{
//		dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
//		You can first pick piles[i] or piles[j].
//
//		If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
//		If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
//		So we get:
//		dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
        int[] dp = Arrays.copyOf(piles, piles.length);;
        for (int d = 1; d < piles.length; d++)
        {
            for (int i = 0; i < piles.length - d; i++)
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + d] - dp[i]);
        }
        return dp[0] > 0;
    }
	
	// Returns optimal value possible that a player 
    // can collect from an array of coins of size n. 
    // Note than n must be even 
	// There are two choices:
    // 1. The user chooses the ith coin with value Vi: The opponent either chooses (i+1)th coin or jth coin. The opponent intends to choose the coin which leaves the user with minimum value.
    // i.e. The user can collect the value Vi + min(F(i+2, j), F(i+1, j-1) )
    // 2. The user chooses the jth coin with value Vj: The opponent either chooses ith coin or (j-1)th coin. The opponent intends to choose the coin which leaves the user with minimum value.
    // i.e. The user can collect the value Vj + min(F(i+1, j-1), F(i, j-2) )
    static int optimalStrategyOfGame(int arr[], int n) 
    { 
        // Create a table to store solutions of subproblems 
        int table[][] = new int[n][n]; 
        int gap, i, j, x, y, z; 
  
        // Fill table using above recursive formula. 
        // Note that the tableis filled in diagonal 
        // fashion (similar to http:// goo.gl/PQqoS), 
        // from diagonal elements to table[0][n-1] 
        // which is the result. 
        for (gap = 0; gap < n; ++gap) 
        { 
            for (i = 0, j = gap; j < n; ++i, ++j) { 
  
                // Here x is value of F(i+2, j), 
                // y is F(i+1, j-1) and z is 
                // F(i, j-2) in above recursive formula 
                x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
                z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
  
                table[i][j] = Math.max(arr[i] + Math.min(x, y),  
                                       arr[j] + Math.min(y, z)); 
            } 
        } 
  
        return table[0][n - 1]; 
    } 
	
	public static void main(String[] args) {
		StoneGame obj = new StoneGame();
		System.out.println(obj.stoneGame(new int [] {5, 3, 7, 10}));

	}

}
