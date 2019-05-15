//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
//Example 1:
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Time: O(n)

// Minimum Jumps
// Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
// Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
// Time: o(n)

package Extra;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		JumpGame obj = new JumpGame();
		System.out.println(obj.minJumps(nums));
	}

	public boolean canJump(int[] nums) 
	{
        int reachable = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
            count++;
        }
        System.out.println(count + reachable);
        return true;
    }
	
	static int minJumps(int arr[]) 
    { 
        if (arr.length <= 1) 
            return 0; 
  
        // Return -1 if not possible to jump 
        if (arr[0] == 0) 
            return -1; 
  
        // initialization 
        int maxReach = arr[0]; 
        int step = arr[0]; 
        int jump = 1; 
  
  
        // Start traversing array 
        for (int i = 1; i < arr.length; i++) 
        { 
            // Check if we have reached the end of the array 
            if (i == arr.length - 1) 
                return jump; 
  
            // updating maxReach 
            maxReach = Math.max(maxReach, i+arr[i]); 
  
            // we use a step to get to the current index 
            step--; 
  
            // If no further steps left 
            if (step == 0) 
            { 
                //  we must have used a jump 
                jump++; 
                   
                //Check if the current index/position  or lesser index 
                // is the maximum reach point from the previous indexes 
                if(i>=maxReach) 
                   return -1; 
  
                // re-initialize the steps to the amount 
                // of steps to reach maxReach from position i. 
                step = maxReach - i; 
            } 
        } 
  
        return -1; 
    } 
}
