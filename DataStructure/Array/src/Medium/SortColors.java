//Example:
//
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]

// Time: O(n)

package Medium;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] nums) 
	{
        int pivot0 = 0;
        int pivot2 = nums.length - 1;
        for(int i = 0;i<= pivot2;)
        {
            //0 from the end may swap to nums[i], therefore we should check 2 first then 0
            //swap 2 to the end, and then pivot2--
            if(nums[i] == 2)
            {                   
                int temp = nums[pivot2];
                nums[pivot2] = 2;
                nums[i] = temp;
                pivot2--;
            }
            //swap 0 to the head, and then pivot0++
            if(nums[i] == 0) 
            {                  
                int temp = nums[pivot0];
                nums[pivot0] = 0;
                nums[i] = temp;
                pivot0++;
                i++;
            }
            else if(nums[i] == 1) 
                i++;
        }
    }
}
