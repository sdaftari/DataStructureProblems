//Input: [1,3,5,4,7]
//Output: 3
//Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
//Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
// Time: O(n)

//Example:
//Input: [10,9,2,5,3,7,101,18]
//Output: 4 
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
// Time: O(nlogn).  Space: O(n)

package Medium;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int cnt = 0, res = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            if (i == 0 || nums[i-1] < nums[i])
                res = Math.max(res, ++cnt);
            else
                cnt = 1;
        }
        
        return res;
    }
	
	// Longest Increasing Subsequence
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp,len,nums[i]);
            if (nums[i] < dp[pos]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len+1;
    }
    private int binarySearch(int[] dp, int len, int val) {
        int left = 0;
        int right = len;
        while(left+1 < right) {
            int mid = left + (right-left)/2;
            if (dp[mid] == val) {
                return mid;
            } else {
                if (dp[mid] < val) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (dp[right] < val) return len+1;
        else if (dp[left] >= val) return left;
        else return right;
    }
}
