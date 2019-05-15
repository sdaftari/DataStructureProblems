//Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, 
//he would be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.In order to maximize the total tip value they decided to distribute the order among themselves. 
//One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders. It is guaranteed that X + Y is greater than or 
//equal to N, which means that all the orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing all the orders.
// Time: O(x*y)
package Hard;

public class MaxTipCalculator {
	
	private static int getMaxTip(int x, int y, int n, int[] A, int[] B) 
	{
		// dp[i][j] stores te max tip that can be generated when A does i jobas and B does j jobs from among the first i+j jobs
	     int[][] dp = new int[x + 1][y + 1];

	     dp[0][0] = 0;
	     // When A takes all the jobs
	     for (int i = 1; i <= x; i++) {
	         dp[i][0] = (i <= n) ? dp[i - 1][0] + A[i - 1] : dp[i - 1][0];
	     }

	     // When B takes all the jobs
	     for (int i = 1; i <= y;i++) {
	         dp[0][i] = (i <= n) ? dp[0][i - 1] + B[i - 1] : dp[0][i - 1];
	     }

	     // When A takes i jobs and B takes j jobs
	     for (int i = 1;i <= x;i++) 
	     {
	         for (int j = 1;j <= y;j++) 
	         {
	        	 // if we give (i+j)th job to A, then tip is dp[i - 1][j] + A[i + j - 1]. Since (A takes i-1 jobs before this job and B takes j jobs). So add previous max and current job's tip for A
	             if (i + j <= n) {
	                 dp[i][j] = Math.max(dp[i - 1][j] + A[i + j - 1], dp[i][j - 1] + B[i + j - 1]);
	             }
	         }
	     }

	     int ans = Integer.MIN_VALUE;
	     // Look for max when i+j = n
	     for (int i = 0;i <= x;i++) {
	         for (int j = 0;j <= y;j++) {
	             if (i + j == n) {
	                 ans = Math.max(ans, dp[i][j]);
	             }
	         }
	     }
	     return ans;
	 }

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {5, 4, 3, 2, 1};
		System.out.println(getMaxTip(3, 3, 5, A, B));
	}

}
