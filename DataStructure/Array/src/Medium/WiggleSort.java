//Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//Example:
//Input: nums = [3,5,2,1,6,4]
//Output: One possible answer is [3,5,1,6,2,4]

// Time: O(n). Space: In-place

package Medium;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void wiggleSort(int[] nums) 
    {
        for(int i = 0; i < nums.length; i++)
        {
            if (i%2 == 1)
            {
                if(nums[i-1] > nums[i]) 
                    swap(nums, i);
            }
            else if (i != 0 && nums[i-1] < nums[i])
                swap(nums, i);
                
        }
    }
    
    public void swap(int[] nums, int i)
    {
          int tmp=nums[i];
          nums[i]=nums[i-1];
          nums[i-1]=tmp;
    }
}
