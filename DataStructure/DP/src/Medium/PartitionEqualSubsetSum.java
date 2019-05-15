//Example 1:
//Input: [1, 5, 11, 5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Time: O(N^2). Space: O(N)

package Medium;
import java.util.*;

public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) 
	{
		int sum = 0;
	    
	    for (int num : nums) 
	        sum += num;
	    
	    if ((sum & 1) == 1) 
	        return false;
	    
	    sum /= 2;
	    
	    boolean[] dp = new boolean[sum+1];
	    Arrays.fill(dp, false);
	    dp[0] = true;
	    
	    for (int num : nums) 
	    {
	        for (int i = sum; i > 0; i--) 
	        {
	        	// Similar to 0/1 knapsack
	        	// If current sum is greater than number, then check if current dp[i] (not considering that number)
	        	// of dp[i-num] considering that number is true
	            if (i >= num) 
	                dp[i] = dp[i] || dp[i-num];
	        }
	    }
	    
	    return dp[sum];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
