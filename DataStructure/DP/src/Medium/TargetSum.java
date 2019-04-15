//Example 1:
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//There are 5 ways to assign symbols to make the sum of nums be target 3.

package Medium;

public class TargetSum {
	
	public int findTargetSumWays(int[] nums, int S) 
	{
        int sum = 0; 
        for(int i: nums) 
            sum+=i;
        
        if(S > sum || S < -sum) 
            return 0;
        
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++)
        {
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++)
            {
                if(dp[k]!=0)
                {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+S];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
