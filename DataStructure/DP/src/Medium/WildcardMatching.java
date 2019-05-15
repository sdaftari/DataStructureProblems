//Example 4:
//
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
//Example 5:
//
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
// Time: O(n^2) Space: O(n^2)

package Medium;

public class WildcardMatching {
	
	public boolean isMatch(String s, String p) 
	{
        if(s==null || p == null)
            return s == p;
        
        // String as rows and pattern as cols
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        // Take care of the first row for *. First col will be false
        // If first character is not *, break 
        for(int col = 1; col < dp[0].length; col++)
        {
            if(p.charAt(col-1) == '*')
                dp[0][col] = true;
            else
                break;
        }
        
        for(int row = 1; row < dp.length; row++)
        {
            for(int col = 1; col < dp[0].length; col++)
            {
                char str = s.charAt(row-1);
                char pattn = p.charAt(col-1);
                // If the characters are matching or its a ?, take value from diagonal
                if(str == pattn || pattn == '?')
                    dp[row][col] = dp[row-1][col-1];
                // Otherwise look for left or top in case of *
                else if(pattn == '*')
                    dp[row][col] = dp[row][col-1] || dp[row-1][col];
            }
        }
        
        return dp[s.length()][p.length()];
    }

	public static void main(String[] args) {
		String s = "acdcb";
		String p = "a*c?b";
		WildcardMatching obj = new WildcardMatching();
		System.out.println(obj.isMatch(s, p));
	}

}
