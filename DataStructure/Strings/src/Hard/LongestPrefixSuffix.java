//Given a string of character, find the length of longest proper prefix which is also a proper suffix.
//Example:
//S = abab
//lps is 2 because, ab.. is prefix and ..ab is also a suffix.
//
//Example:
//Input:
//2
//abab
//aaaa
//
//Output:
//2
//3
//
//Time Complexity : O(n)
//Auxiliary Space : O(n)

package Hard;

public class LongestPrefixSuffix {

	// Returns length of the longest prefix 
    // which is also suffix and the two do 
    // not overlap. This function mainly is 
    // copy computeLPSArray() of in below post 
    // https://www.geeksforgeeks.org/searching- 
    // for-patterns-set-2-kmp-algorithm/ 
    static int longestPrefixSuffix(String s) 
    { 
        int n = s.length(); 
      
        int lps[] = new int[n]; 
          
        // lps[0] is always 0 
        lps[0] = 0;  
      
        // length of the previous 
        // longest prefix suffix 
        int len = 0; 
      
        // the loop calculates lps[i] 
        // for i = 1 to n-1 
        int i = 1; 
        while (i < n) 
        { 
            if (s.charAt(i) == s.charAt(len)) 
            { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
              
             // (pat[i] != pat[len]) 
            else
            { 
                // This is tricky. Consider 
                // the example. AAACAAAA 
                // and i = 7. The idea is 
                // similar to search step. 
                if (len != 0) 
                { 
                    len = lps[len-1]; 
      
                    // Also, note that we do 
                    // not increment i here 
                } 
                  
                // if (len == 0) 
                else 
                { 
                    lps[i] = 0; 
                    i++; 
                } 
            } 
        } 
      
        int res = lps[n-1]; 
      
        // Since we are looking for 
        // non overlapping parts. 
        return (res > n/2)? n/2 : res; 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
