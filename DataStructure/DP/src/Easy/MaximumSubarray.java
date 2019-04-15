//*
// * Kadane's Algo:
// * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). 
// * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
// * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
// * 4 to 5 = 7
// */
//Example:
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//Time: O(n)

package Easy;


public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(obj.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) 
	{
        int maxSumSoFar = nums[0], maxSumEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            maxSumEndingHere = Math.max(maxSumEndingHere + nums[i], nums[i]);
            maxSumSoFar = Math.max(maxSumEndingHere, maxSumSoFar);
        }
        
        return maxSumSoFar;
    }
}
