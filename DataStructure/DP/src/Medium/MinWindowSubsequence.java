//Example 1:
//Input: 
//S = "abcdebdde", T = "bde"
//Output: "bcde"
//Explanation: 
//"bcde" is the answer because it occurs before "bdde" which has the same length.
//"deb" is not a smaller window because the elements of T in the window must occur in order.

package Medium;

public class MinWindowSubsequence {
	
	public String minWindow(String S, String T) 
	{
		// dp[i][j] stores the starting index of the substring where T has length i and S has length j.
		//	So dp[i][j would be:
		//	if T[i - 1] == S[j - 1], this means we could borrow the start index from dp[i - 1][j - 1] to make the current substring valid;
		//	else, we only need to borrow the start index from dp[i][j - 1] which could either exist or not.
		//	Finally, go through the last row to find the substring with min length and appears first.
		
	    int m = T.length(), n = S.length();
	    int[][] dp = new int[m + 1][n + 1];
	    for (int j = 0; j <= n; j++) 
	        dp[0][j] = j + 1;
	    
	    for (int i = 1; i <= m; i++) 
	    {
	        for (int j = 1; j <= n; j++) 
	        {
	            if (T.charAt(i - 1) == S.charAt(j - 1)) 
	                dp[i][j] = dp[i - 1][j - 1];
	            else 
	                dp[i][j] = dp[i][j - 1];
	        }
	    }

	    int start = 0, len = n + 1;
	    for (int j = 1; j <= n; j++) 
	    {
	        if (dp[m][j] != 0) 
	        {
	            if (j - dp[m][j] + 1 < len) 
	            {
	                start = dp[m][j] - 1;
	                len = j - dp[m][j] + 1;
	            }
	        }
	    }
	    return len == n + 1 ? "" : S.substring(start, start + len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
