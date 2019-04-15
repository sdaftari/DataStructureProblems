//Example:
//Given nums = [0,0,1,1,1,2,2,3,3,4],
//Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
// Time: O(n)

// Remove Duplicates II
// Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// Time: O(n). Space: O(1). In-place

package Easy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		System.out.println(obj.removeDuplicates(nums));
	}

	// Removes all the duplicates
	public int removeDuplicates(int[] nums) 
	{
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        for(int i = 1; i <n; i++)
        {
            if(nums[i] == nums[i-1]) 
                count++;
            else 
                nums[i-count] = nums[i];
        }
        return n-count;
    }
	
	// Allows k duplicates
	public int removeDuplicatesII(int[] nums) {
        int n = nums.length, k = 2;
        if (n <= k)
			return n;
		
		// i maintains index of final nums
		int i = 1, j = 1;
        int cnt = 1;
        
        while (j < n)
        {
        	if (nums[j-1] != nums[j])
        	{
        		cnt = 1;
        		nums[i++] = nums[j];
        	}
        	else
        	{
        		if (cnt < k)
        		{
        			nums[i++] = nums[j];
        			cnt++;
        		}
        	}
        	j++;
        }
        
        return i;
    }
}
