//Example 1:
//Input: nums = [10, 5, 2, 6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
//Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

package Medium;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        long p = 1l;
        int i = 0, j = 0;
        int total = 0;
        while (j < n)
        {
            p *= nums[j];
            while(i <= j && p >= k)
            {
                p /= nums[i];
                i++;
            }
            
            //now the length of valid subarray is j - i + 1,and since the array have only positive numbers
            //All subarrays with length 1 ~ j - i + 1 ending with nums[j] are valid,and there are j - i + 1 of them.
            total += (j - i + 1);
            j++;
        }
        
        return total;
    }
}
