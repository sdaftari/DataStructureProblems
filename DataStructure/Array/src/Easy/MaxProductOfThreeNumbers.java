//Example 2:
//
//Input: [1,2,3,4]
//Output: 24

// Time: O(n logn)

package Easy;
import java.util.*;
public class MaxProductOfThreeNumbers {

	public static void main(String[] args) {
		int[] nums = {1, 100, 42, 4, 23};
		MaxProductOfThreeNumbers obj = new MaxProductOfThreeNumbers();
		System.out.println(obj.maximumProductOfTwo(nums));
	}

	public int maximumProduct(int[] nums) 
	{
        Arrays.sort(nums);
        
        int maxPosProduct = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int maxNegProduct = nums[0] * nums[1] * nums[nums.length-1];
        
        return maxPosProduct > maxNegProduct ? maxPosProduct : maxNegProduct;
    }
	
	public int maximumProductOfTwo(int[] nums) 
	{
        Arrays.sort(nums);
        
        int maxPosProduct = nums[nums.length - 1] * nums[nums.length - 2];
        int maxNegProduct = nums[0] * nums[nums.length-1];
        
        return maxPosProduct > maxNegProduct ? maxPosProduct : maxNegProduct;
    }
}
