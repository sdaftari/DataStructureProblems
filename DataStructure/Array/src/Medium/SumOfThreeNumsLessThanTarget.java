package Medium;

import java.util.*;
public class SumOfThreeNumsLessThanTarget {
	int count;
	public static void main(String[] args) {
		SumOfThreeNumsLessThanTarget obj = new SumOfThreeNumsLessThanTarget();
		System.out.println(obj.sumSmallerThanTarget(new int[]{-2, 0, 1, 3}, 2));		
	}

	private int sumSmallerThanTarget(int[] nums, int target)
	{
		count = 0;
        Arrays.sort(nums);
        int len = nums.length;
    
        for(int i=0; i<len-2; i++)
        {
        	int left = i+1, right = len-1;
        	while(left < right) 
        	{
                if(nums[i] + nums[left] + nums[right] < target) 
                {
                    count += right-left;
                    left++;
                } 
                else 
                    right--;
            }
        }
        
        return count;
	}
}
