//Example 2:
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5 
//Explanation: Your function can return either index number 1 where the peak element is 2, 
//             or index number 5 where the peak element is 6.
//             
//Time: O(log n)

package Medium;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
        int peak = -1;
        if(nums == null || nums.length ==0)
            return peak;
        
        int low = 0, high = nums.length-1;
        while(low<=high) 
        {
            int mid = (low+high) >> 1;
            if(mid == nums.length-1 || nums[mid] > nums[mid+1]) 
            {
                peak = mid;
                high = mid-1;
            } else 
               low = mid+1;
        }
        
        return peak;
    }
}
