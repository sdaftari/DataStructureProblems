//Example 1:
//Input: [1,1,2,2,2]
//Output: true
//
//Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

package Medium;
import java.util.*;

public class MatchsticksToSquare {
	
	private int edge;
    public boolean makesquare(int[] nums) {
        int totalSum = 0;
        // Get the total sum of all edges
        for(int n : nums)
            totalSum += n;
        
        // If its not divisible by 4, return
        if(totalSum % 4 != 0)
            return false;
        
        // Fix the edge of a square
        this.edge = totalSum / 4;  // the square edge length
        
        Arrays.sort(nums);

        int remainCount = nums.length;
        boolean[] used = new boolean[nums.length];

        return dfs(nums, 0, 0,used, remainCount);
    }
    
    private boolean dfs(int[] nums, int currSum, int count, boolean[] used, int remainCount)
    {
        if(currSum == edge)
        {
            // number of the length
            count++; 
            
            if(count == 4)
                return remainCount == 0;
            
            currSum = 0;
        }
        
        if(currSum > edge)
            return false;
        
        // backTracking method.
        for (int i = nums.length-1; i >= 0; i--)
        {
            if(used[i])
            	continue;
            
            // very important, since currSum <= edge, if currSum > edge, we need return false
            if(currSum + nums[i] > edge)
                break;  
            
            used[i] = true;
            if(dfs(nums, currSum + nums[i], count, used, remainCount -1))
                return true;
            used[i] = false;
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
