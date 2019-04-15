//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//
//Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
//
//Example 1:
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

// Time: O(N) Space: O(1)

package Easy;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCostClimbingStairs(int[] cost) {
        int twoStepBefore = cost[0];
        int oneStepBefore = cost[1];
        int curr = 0;
        for(int i = 2;i< cost.length;i++)
        {
            // Consider the min cost from previous two steps
            curr = Math.min(twoStepBefore,oneStepBefore) + cost[i];
            twoStepBefore = oneStepBefore;
            oneStepBefore = curr;
        }
        
        return Math.min(oneStepBefore,twoStepBefore);
    }
}
