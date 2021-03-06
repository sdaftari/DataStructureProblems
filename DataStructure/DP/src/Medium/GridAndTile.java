//Given a number n, count number of ways to fill a n x 4 grid using 1 x 4 tiles.
//Examples:
//
//Input : n = 1
//Output : 1
//
//Input : n = 2
//Output : 1
//We can only place both tiles horizontally
//
//Input : n = 3
//Output : 1
//We can only place all tiles horizontally.
//
//Input : n = 4
//Output : 2
//The two ways are : 
//  1) Place all tiles horizontally 
//  2) Place all tiles vertically.
//
//Input : n = 5
//Output : 3
//We can fill a 5 x 4 grid in following ways : 
//  1) Place all 5 tiles horizontally
//  2) Place first 4 vertically and 1 horizontally.
//  3) Place first 1 horizontally and 4 horizontally.

//Time Complexity : O(n)
//Auxiliary Space : O(n)

package Medium;

public class GridAndTile {
	
	// Function that count the number of ways to place 1 x 4 tiles 
    // on n x 4 grid. 
    static int count(int n) 
    { 
        // Create a table to store results of sub-problems 
        // dp[i] stores count of ways for i x 4 grid. 
        int[] dp = new int[n+1]; 
        dp[0] = 0; 
        // Fill the table from d[1] to dp[n] 
        for(int i = 1; i <= n; i++) 
        { 
            // Base cases 
        	// If we have upto three rows, we can only for 1*4 tile in horizontal way
            if (i >= 1 && i <= 3) 
                dp[i] = 1; 
            // If we have 4 rpws, we can either fir horizontally or vertically. So 2 ways
            else if (i==4) 
                dp[i] = 2 ; 
  
            else
            { 
                    // dp(i-1) : Place first tile horizontally 
                    // dp(i-4) : Place first tile vertically 
                    //         which means 3 more tiles have 
                    //         to be placed vertically. 
                    dp[i] = dp[i-1] + dp[i-4]; 
            } 
        } 
        return dp[n]; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
