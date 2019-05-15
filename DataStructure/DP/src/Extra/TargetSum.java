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
//Time: O(n^2), Space: O(n)

package Extra;

public class TargetSum {
	// if we calculate total sum of all candidate numbers, then the range of possible calculation result will be in
	// the range [-sum, sum]. So we can define an dp array with size sum * 2 + 1 to calculate number of possible ways
	// to reach every target value between -sum to sum, and save results to dp array. dp[sum + S] will be out final
	// result. (because dp[sum] or less represents number of possible ways to reach a number in range [-sum, 0])
	public int findTargetSumWays(int[] nums, int S) 
    {
		if (nums.length == 0) 
	        return 0;

	    int sum = 0;
	    for (int num : nums) 
	       sum += num;

	    // corner case: when S is out of range [-sum, sum]
	    if (S < -sum || S > sum) 
	        return 0;

	    int[] dp = new int[sum * 2 + 1];
	    dp[sum] = 1;
	    //Start from deciding to add the first element as positive or negative
	    for (int i = 0; i < nums.length; i++) 
	    {
	        int[] tempTarget = new int[sum * 2 + 1];
	        for (int j = 0; j < sum * 2 + 1; j++) 
	        {
	            // WARNING: DO NOT FORGET to check condition whether dp[i] is 0 or not
	            // if it is NOT 0, it means we at least have one possible way to reach target j. Otherwise, we may have
	            // array out of bound exception
	        	//if current sum j - totalSum is already reached by the previous searched numbers
	            if (dp[j] != 0) 
	            {
	            	//plus the num of ways to have sum = j - totalSum to the num of ways to have sum = j + nums[i] - totalSum 
	                tempTarget[j + nums[i]] += dp[j];
	                tempTarget[j - nums[i]] += dp[j];
	            }
	            //Since currSum + nums[i] no larger than totalSum, -currSum - nums[i] no smaller than -totalSum, so it won't exceed the boundary
	        }
	        dp = tempTarget;
	    }
	    //return the num of ways to have sum = S
	    return dp[sum + S];
    } 

	public static void main(String[] args) {
		int[] nums= {1, 1, 1, 1, 1};
		TargetSum obj = new TargetSum();
		System.out.println(obj.findTargetSumWays(nums, 3));
	}

}
