package Medium;

public class MaxTipCalculator {
	
	private static int getMaxTip(int x, int y, int n, int[] A, int[] B) 
	{
	     int[][] dp = new int[x + 1][y + 1];

	     dp[0][0] = 0;
	     for (int i = 1;i <= x;i++) {
	         dp[i][0] = (i <= n) ? dp[i - 1][0] + A[i - 1] : dp[i - 1][0];
	     }

	     for (int i = 1;i <= y;i++) {
	         dp[0][i] = (i <= n) ? dp[0][i - 1] + B[i - 1] : dp[0][i - 1];
	     }

	     for (int i = 1;i <= x;i++) {
	         for (int j = 1;j <= y;j++) {
	             if (i + j <= n) {
	                 dp[i][j] = Math.max(dp[i - 1][j] + A[i + j - 1], dp[i][j - 1] + B[i + j - 1]);
	             }
	         }
	     }

	     int ans = Integer.MIN_VALUE;
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
