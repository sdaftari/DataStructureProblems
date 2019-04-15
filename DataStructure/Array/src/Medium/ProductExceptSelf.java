//Example:
//Input:  [1,2,3,4]
//Output: [24,12,8,6]

// Time: O(n), Space: O(n)

package Medium;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4};
		ProductExceptSelf obj = new ProductExceptSelf();
		int[] res = obj.productExceptSelf(nums);
		for (int i : res)
			System.out.print(i + " ");
	}

	public int[] productExceptSelf(int[] nums) 
	{
        int n = nums.length;
	    int[] res = new int[n];
	    
	    res[0] = 1;	    
	    for (int i = 1; i < n; i++) 
	    {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) 
	    {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    
	    return res;
    }
}
