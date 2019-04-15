//Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Time: O(log n)

package Medium;

public class FirstAndLastPositionInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0)
            return result;
        
        int i = 0;
        int j = nums.length - 1;
        // this should find a target if present
        while (i < j)
        {
            int mid = (i+j)/2;
            if (nums[mid] < target)
                i = mid+1;
            else
                j = mid;
        }
        
        if(nums[i] != target) 
            return result;
        else 
            result[0] = i;
        
        j = nums.length-1;
        while (i < j)
        {
            int mid = (i+j)/2 + 1;
            if(nums[mid] > target)
                j = mid - 1;
            else
                i = mid;
        }
        
        result[1] = j;
        return result;
    }
}
