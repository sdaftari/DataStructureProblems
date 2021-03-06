//Example 1:
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.

// House Robber II
//Example:
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.

// Similar to Maximum Sum Such That No Two Elements Are Consecutive

//Complexity O(n)

package Easy;

public class HouseRobber {

	public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev1 = 0, prev2 = 0;
        for (int num : nums)
        {
            int temp = prev1;
            // select max between prev or prev to prev and current
            prev1 = Math.max(prev1, prev2+num);
            prev2 = temp;
        }
        
        return prev1;
    }
	
	
	// House Robber II
	// houses at this place are arranged in a circle. 
	public int robII(int[] nums) {
        if (nums.length == 1) 
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] num, int lo, int hi) 
    {
    	int prev1 = 0, prev2 = 0;
        for (int j = lo; j <= hi; j++) 
        {
        	int temp = prev1;
        	prev1 = Math.max(prev1, prev2+num[j]);
        	prev2 = temp;
        }
        
        return prev1;
    }
	
	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();
		int[] nums = {5, 5, 10, 100, 10, 5};
		System.out.println(obj.robII(nums));
	}

}
