//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Note: Given n will be a positive integer.
//Example 1:
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps

// The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively, 
//denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n]. 
// And from the [n-2] point, we could take two steps to get there.

package Easy;

public class ClimbingStairs {

	public int climbStairs(int n) 
	{
        // base cases
        if(n <= 0) 
        	return 0;
        if(n == 1) 
        	return 1;
        if(n == 2) 
        	return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for(int i = 2; i < n; i++)
        {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways; 
        }
        
        return all_ways;
    }
	
	public static void main(String[] args) {
		ClimbingStairs obj = new ClimbingStairs();
		System.out.println(obj.climbStairs(5));
	}

}
