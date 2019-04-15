//Example for closest three sum:
//Given array nums = [-1, 2, 1, -4], and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

package Medium;
import java.util.*;

// Time: O(n^2) for both
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) 
	{
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) 
        {
        	// skip same result
            if (i > 0 && nums[i] == nums[i - 1])               
                continue;
        
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i];
            while (j < k) 
            {
                if (nums[j] + nums[k] == target) 
                {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip same result
                    while (j < k && nums[j] == nums[j - 1]) 
                    	j++;  
                    // skip same result
                    while (j < k && nums[k] == nums[k + 1]) 
                    	k--;  
                } 
                else if (nums[j] + nums[k] > target) 
                    k--;
                else 
                    j++;
            }
        }
        return res;
    }
	
	// Similar code to get the closest sum of target
	public int threeSumClosest(int[] nums, int target) 
	{
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            int start = i + 1, end = nums.length - 1;
            while (start < end)
            {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target)
                    end--;
                else
                    start++;
                
                if (Math.abs(sum - target) < Math.abs(result - target)) 
                    result = sum;
            }
        }
        
        return result;
    }
}
