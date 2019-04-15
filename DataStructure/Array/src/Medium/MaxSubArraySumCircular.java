//Example 1:
//Input: [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3
//
//Example 2:
//Input: [5,-3,5]
//Output: 10
//Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
//
//Time: O(n)

package Medium;

public class MaxSubArraySumCircular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, minSum = 30000, currMin = 0, currMax = 0;
        for (int a : A)
        {
            currMin = Math.min(currMin + a, a);
            minSum = Math.min(minSum, currMin);
            currMax = Math.max(currMax + a, a);
            maxSum = Math.max(maxSum, currMax);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
