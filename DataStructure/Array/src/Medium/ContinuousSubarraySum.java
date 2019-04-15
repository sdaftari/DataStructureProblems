//Example 1:
//Input: [23, 2, 4, 6, 7],  k=6
//Output: True
//Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//Example 2:
//Input: [23, 2, 6, 4, 7],  k=6
//Output: True
//Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
// Time: O(n) and Space: O(k)

package Medium;
import java.util.*;

public class ContinuousSubarraySum {
	
	public boolean checkSubarraySum(int[] nums, int k) 
	{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) 
        {
            runningSum += nums[i];
            if (k != 0) 
                runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) 
            {
                if (i - prev > 1) 
                    return true;
            }
            else 
                map.put(runningSum, i);
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
