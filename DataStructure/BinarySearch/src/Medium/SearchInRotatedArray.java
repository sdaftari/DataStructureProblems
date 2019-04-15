// Search
//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

// Time: O(log n) for bioth

package Medium;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {4,5,6,7,0,1,2};
		SearchInRotatedArray obj = new SearchInRotatedArray();
		System.out.println(obj.search(nums, 1));
	}

	public int search(int[] nums, int target) 
	{
        if (nums == null || nums.length == 0)
            return -1;
        int lo = 0, hi = nums.length-1;
        while (lo < hi)
        {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) 
                return mid;
            
            // Array is not rotated
            if (nums[lo] <= nums[mid])
            {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid-1;
                else 
                    lo = mid + 1;
            }
            else 
            {
                if (target > nums[mid] && target <= nums[hi]) 
                    lo = mid + 1;
                 else 
                    hi = mid - 1;
            }
        }        
         return nums[lo] == target ? lo : -1;
    }
	
	// Find min in sorted array (no duplicate)
	public int findMin(int[] nums) 
	{
        int left = 0;
        int right = nums.length-1;
        while(left < right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) 
                left = mid + 1;
            else 
                right = mid;
        }
        return nums[left];
    }
}
