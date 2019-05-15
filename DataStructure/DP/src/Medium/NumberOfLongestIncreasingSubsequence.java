//Example 1:
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
// Time: O(n^2) Space: O(n)

package Medium;

public class NumberOfLongestIncreasingSubsequence 
{
//	The idea is to use two arrays len[n] and cnt[n] to record the maximum length of Increasing Subsequence and the coresponding number of these sequence which ends with nums[i], respectively. That is:
//	len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
//	cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
//	Then, the result is the sum of each cnt[i] while its corresponding len[i] is the maximum length.
	public int findNumberOfLIS(int[] nums) 
	{
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++)
        {
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++)
            {
                if(nums[i] > nums[j])
                {
                	// In this case, the previous value is greater than current, so there are two sequences
                    if(len[i] == len[j] + 1)
                    	cnt[i] += cnt[j];
                    // If the sequence until now is increasing, increment the length by one and keep cnt same
                    if(len[i] < len[j] + 1)
                    {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            // If length is same, then two sequences are found. so add cnt to res
            if(max_len == len[i])
            	res += cnt[i];
            if(max_len < len[i])
            {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		NumberOfLongestIncreasingSubsequence obj = new NumberOfLongestIncreasingSubsequence();
		System.out.print(obj.findNumberOfLIS(nums));
	}

}
