//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. 
//You have to paint all the houses such that no two adjacent houses have the same color.The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
//For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
//Example: Paint House I
//Input: [[17,2,17],[16,16,5],[14,3,19]]
//Output: 10
//Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.

// Example: (Paint House II)
//There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent 
//houses have the same color.The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] 
//is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
//Example:
//Input: [[1,5,3],[2,9,4]]
//Output: 5
//Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
//             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

package Hard;

public class PaintHouse {
	
	public int minCost(int[][] costs) 
	{
        if(costs == null || costs.length == 0)
            return 0;
        int[] pre = new int[3];
        int[] cur = new int[3];
        // Initially, pre stores cost of paining 0th house with colors 0, 1, 2 respectively
        for(int j = 0; j < 3; j++)
            pre[j] = costs[0][j];
        
        // if j==0, dp[i][0] = costs[i][0] + Math.min(the min cost of painting (i-1)th house with either blue or green) = 
        // costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]).
        // No w start from 1st house, cur[0] will sabe cost of paining ith house with color 0 and so prev house will be min(1, 2)
        for(int i = 1; i < costs.length; i++)
        {
            // If we paint red, we will paint i-1th house with min blue and green
            cur[0] = costs[i][0] + Math.min(pre[1], pre[2]);
            cur[1] = costs[i][1] + Math.min(pre[0], pre[2]);
            cur[2] = costs[i][2] + Math.min(pre[0], pre[1]);
            
            int[] temp = pre;
            pre = cur;
            cur = temp; 
        }
        
        return Math.min(pre[0], Math.min(pre[1], pre[2]));   
    }
	
	public int minCostII(int[][] costs) 
	{
		if(costs == null || costs.length == 0)
	        return 0;
	 
		// Previous min cost
	    int preMinCost = 0;
	    // previous second min cost
	    int preSecondMinCost = 0;
	    // Index of previous min cost
	    int preIndex=-1; 
	 
	    for(int i = 0; i < costs.length; i++)
	    {
	        int currMinCost = Integer.MAX_VALUE;
	        int currSecondMinCost = Integer.MAX_VALUE;
	        int currIndex = 0;
	 
	        for(int j = 0; j < costs[0].length; j++)
	        {
	        	// if pre index is not j, so use the second min cost
	            if(preIndex == j)
	                costs[i][j] += preSecondMinCost;
	            else
	                costs[i][j] += preMinCost;
	 
	            // If smaller cost than cur min is found, keep that as cur min and
	            // change curr min to second curr min
	            if(currMinCost > costs[i][j])
	            {
	            	currSecondMinCost = currMinCost;
	            	currMinCost = costs[i][j];
	                currIndex = j;
	            } 
	            else if(currSecondMinCost > costs[i][j])
	            	currSecondMinCost = costs[i][j];
	        }
	 
	        preMinCost = currMinCost;
	        preSecondMinCost = currSecondMinCost;
	        preIndex = currIndex;
	    }
	 
	    int result = Integer.MAX_VALUE;
	    for(int j = 0; j < costs[0].length; j++)
	    {
	        if(result > costs[costs.length-1][j])
	            result = costs[costs.length-1][j];
	    }
	    return result;
	}

	public static void main(String[] args) 
	{
		int[][] costs = {{1,5,3},{2,9,4}};
		PaintHouse obj = new PaintHouse();
		System.out.println(obj.minCostII(costs));
	}
}
