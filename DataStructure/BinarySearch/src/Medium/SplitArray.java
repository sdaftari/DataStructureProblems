//Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. 
//Write an algorithm to minimize the largest sum among these m subarrays.
//Examples:
//
//Input:
//nums = [7,2,5,10,8]
//m = 2
//Output:
//18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.

package Medium;

public class SplitArray {
	
	public int splitArray(int[] nums, int m) 
	{
        int max = 0; long sum = 0;
        for (int num : nums) 
        {
            max = Math.max(num, max);
            sum += num;
        }
        
        if (m == 1) 
            return (int)sum;
        
        //binary search
        long l = max; long r = sum;
        while (l <= r) 
        {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) 
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return (int)l;
    }
    
    public boolean valid(long target, int[] nums, int m) 
    {
        int count = 1;
        long total = 0;
        for(int num : nums) 
        {
            total += num;
            if (total > target) 
            {
                total = num;
                count++;
                if (count > m) 
                    return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
