//Example 1:
//Input: n = 12
//Output: 3 
//Explanation: 12 = 4 + 4 + 4.
//Example 2:
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.

package Medium;
import java.util.*;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSquares(int n) {
	       int[] dp = new int[n+1];           
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        for(int i=1; i*i<=n; i++) {
	            dp[i*i]=1;
	            for(int sum=1; sum<=n; sum++){
	                int prevVal = sum-i*i >=0 && dp[sum-i*i] != Integer.MAX_VALUE ? dp[sum-i*i]+1 : Integer.MAX_VALUE;
	                dp[sum] = Math.min(dp[sum],prevVal);    
	            }
	        }
	        return dp[n];
	    }
}
