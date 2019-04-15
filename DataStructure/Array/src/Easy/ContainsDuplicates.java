//Contains Duplicates III
//Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t 
//and the absolute difference between i and j is at most k.
//Example 1:
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true


package Easy;
import java.util.*;

// ContainsDuplicates: Time: O(nlogn), Space: O(1)
//ContainsNearbyDuplicate: Time: O(n), Space: O(n)

public class ContainsDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) 
	{
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
	
	// two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(i > k) 
                set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) 
                return true;
        }
        return false;
    }
	
	
	// Contains Duplicates III
	//This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. 
	//The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time complexity O(N lg K). 
	//In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(lg K)
	//Here is the whole solution using TreeMap.
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{
        if(k < 1 || t < 0)
			return false;
		
		TreeSet<Long> values = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) 
        {
			long num = nums[i];	
			Long floor = values.floor(num + t); 
			Long ceil = values.ceiling(num - t); 
			if((floor != null && floor >= num) || (ceil != null && ceil <= num))
				return true;
			
			values.add(num);
			if(i >= k)
				values.remove((long)(nums[i - k]));
		}
		return false;
    }
}
