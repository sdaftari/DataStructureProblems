//Example 1:
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.

package Medium;

public class LongestPalindromicSequence {
	private int lo, maxLen;
    public String longestPalindrome(String s)
    {
    	int len = s.length();
    	if (len < 2)
    		return s;
    	for (int i = 0; i < len-1; i++)
    	{
    		extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
    	}
    	
    	return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) 
    {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) 
        {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) 
        {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
    
    // To count palindromic substrings
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        
        // i is the mid point
        for (int i = 0; i < s.length(); i++)
        {
            extendPalindrome1(s, i, i); // odd length;
            extendPalindrome1(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome1(String s, int left, int right)
    {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
    }
    
    
    // Time: O(n^2)
    // A utility function to get max of two integers 
    static int max (int x, int y) { return (x > y)? x : y; } 
      
    // Returns the length of the longest  
    // palindromic subsequence in seq 
    static int lps(String seq) 
    { 
	    int n = seq.length(); 
	    int i, j, cl; 
	    // Create a table to store results of subproblems 
	    int L[][] = new int[n][n];  
      
	    // Strings of length 1 are palindrome of lentgh 1 
	    for (i = 0; i < n; i++) 
	    	L[i][i] = 1; 
              
        // Build the table. Note that the lower  
        // diagonal values of table are 
        // useless and not filled in the process.  
        // The values are filled in a manner similar 
        //  to Matrix Chain Multiplication DP solution (See 
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).  
        // cl is length of substring  
        for (cl = 2; cl <= n; cl++) 
        { 
            for (i = 0; i < n-cl+1; i++) 
            { 
                j = i+cl-1; 
                // here i is row index and j is col index. Now we will go on filling lines parallel to diagonal
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) 
                	L[i][j] = 2; 
                else if (seq.charAt(i) == seq.charAt(j)) 
                	L[i][j] = L[i+1][j-1] + 2; 
                else
                	L[i][j] = max(L[i][j-1], L[i+1][j]); 
            } 
        } 
              
        return L[0][n-1]; 
    }

	public static void main(String[] args) {
		String abc = "bbabcbcab";
		LongestPalindromicSequence obj = new LongestPalindromicSequence();
		System.out.println(obj.longestPalindrome(abc));
	}

}
