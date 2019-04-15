//Example:
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

package Medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int[] nums = new int[] {2,3,-2,4};
		System.out.println(obj.maxProduct(nums));
	}

	public int maxProduct(int[] nums) 
    {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > res) 
                res = max;
        }
        
        return res;        
    }
}
