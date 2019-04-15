// Unbounded
//Given weights and values related to n items and the maximum capacity allowed for these items. 
//What is the maximum value we can achieve if we can pick any weights any number of times for a total allowed weight of W?

// 0-1 Knapsack
//Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] 
//and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value 
//subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

package Easy;

public class KnapSack {
	
	// Returns the maximum value with knapsack 
    // of W capacity 
    private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) { 
          
        // dp[i] is going to store maximum value 
        // with knapsack capacity i. 
        int dp[] = new int[W + 1]; 
          
        // Fill dp[] using above recursive formula 
        for(int i = 0; i <= W; i++)
        { 
            for(int j = 0; j < n; j++)
            { 
                if(wt[j] <= i)
                { 
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]); 
                } 
            } 
        } 
        return dp[W]; 
    } 
    
    // Returns the maximum value that can be put in a knapsack of capacity W 
    // Time Complexity: O(nW) 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
