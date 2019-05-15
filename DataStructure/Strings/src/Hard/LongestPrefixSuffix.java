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

//Name lps indicates longest proper prefix which is also suffix.. 
//A proper prefix is prefix with whole string not allowed. For example, prefixes of “ABC” are “”, “A”, “AB” and “ABC”. Proper prefixes are “”, “A” and “AB”. Suffixes of the string are “”, “C”, “BC” and “ABC”.

package Hard;

public class LongestPrefixSuffix {

	// Returns length of the longest prefix which is also suffix and the two do not overlap. 
    // kmp-algorithm/ 
	// Example: aaaa - 2
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
                // if len'th character does not match, lps[len-1] will tell us how many previous characters are matching
            	// So we go back those many steps in pattern, i remaining the same
                if (len != 0) 
                { 
                    len = lps[len-1]; 
      
                    // Also, note that we do 
                    // not increment i here 
                } 
                  
                // if (len == 0) 
                // if len == 0, it means no character has matched yet
                // or not a single character is matching so increment i in string and make lps = 0
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
    
    // Prper prefix and suffix 
    // Overlapping is allowed
    // Ex: aaaa - 3
    private static int find(String str, int n) 
    {	
		int len = 0;
	    
	   for(int i=1;i<n;i++)
	   {
		   if(str.substring(0,i).equals(str.substring(n-i,n)))
			   len = i;
	   }
	
	   return len;
	}
    
	public static void main(String[] args) {
		System.out.println(find("aaaa", 4));

	}

}
