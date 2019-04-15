//Example 1:
//Input: 
//S = 'bccb'
//Output: 6
//Explanation: 
//The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
//Note that 'bcb' is counted only once, even though it occurs twice.

package Hard;

public class CountDifferentPalindromicSubsequences 
{
//	Maintain DP[i][j] to record in substring from i to j(included), the number of palindrome without duplicate. Then we consider two cases of the DP equation:
//	when s.charAt(i) != s.charAt(j):
//	dp[i][j] = dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
//	When s.charAt(i) == s.charAt(j):
		
	public int countPalindromicSubsequences(String S) 
	{
        int len = S.length();
        int[] rightNext = new int[len], leftNext = new int[len], rec = new int[4];
        rec[0] = rec[1] = rec[2] = rec[3] = -1;
        
        for (int i = 0; i < len; i++) 
        {
            leftNext[i] = rec[S.charAt(i) - 'a'];
            rec[S.charAt(i) - 'a'] = i;
        }
        
        rec[0] = rec[1] = rec[2] = rec[3] = len;
        for (int i = len - 1; i >=0 ; i--) 
        {
            rightNext[i] = rec[S.charAt(i) - 'a'];
            rec[S.charAt(i) - 'a'] = i;
        }
        
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) 
        	dp[i][i] = 1;
        
        for (int k = 1; k < len; k++) 
        {
            for (int i = 0, j = i + k; j < len; i++, j++) 
            {
                if (S.charAt(i) != S.charAt(j)) 
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                else 
                {
                    int irn = rightNext[i], jln = leftNext[j];
                    if (irn < jln) 
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[irn + 1][jln - 1];
                    else 
                        dp[i][j] = dp[i + 1][j - 1] * 2 + (irn == jln ? 1 : 2);
                }
                
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][len - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
