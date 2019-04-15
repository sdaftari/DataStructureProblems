//Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
//Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
//Example 1:
//Input: [1, 2, 2, 3, 1]
//Output: 2
//Explanation: 
//The input array has a degree of 2 because both elements 1 and 2 appear twice.
//Of the subarrays that have the same degree:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//The shortest length is 2. So return 2.

// Time: O(n)

package Easy;
import java.util.*;

public class DegreeOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findShortestSubArray(int[] nums) 
	{
		Map<Integer, Integer> first = new HashMap<>(), counter = new HashMap<>();
	    int res = 0, degree = 0;
	    for (int i = 0; i < nums.length; i++)
	    {
	    	// Keep track of first occurrence
	        first.putIfAbsent(nums[i], i);
	        
	        // Keep track of total count
	        counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
	        
	        // If the degree is greater than prev, save this res
	        if (counter.get(nums[i]) > degree)
	        {
	            degree = counter.get(nums[i]);
	            res = i - first.get(nums[i]) + 1;
	        }
	        
	        // Else if the degree is same, keep track of min distance
	        else if (counter.get(nums[i]) == degree)
	        {
	            res = Math.min(res, i - first.get(nums[i]) + 1);
	        }
	    }
	    
	    return res;
	}
}
