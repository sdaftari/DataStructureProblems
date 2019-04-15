//Given a string and a pattern, Replace all the continuous occurrence of pattern with a single X in the string. For a clear view see the example below.
//Example:
//
//Input
//2
//abababcdefababcdab
//ab
//geeksforgeeks
//geeks
//
//Output
//XcdefXcdX
//XforX

package Medium;

public class ReplaceByX {
	
	private static String replace(String str, String pattern)
	{
	    if (pattern == null)
	        return str;
	        
	    int len = pattern.length();
	    if (len == 0)
	        return str;
	    int i = 0, j = 0; 
        int count; 
        while (j < str.length())
        {
            count = 0; 
            if (str.charAt(j) == pattern.charAt(0))
            {
	            while (isMatch(str, pattern, j) == true)
	            {
	            	j += len;
	                count++;
	                if (j == str.length())
	                	break;
	            }
            }
            
            if (count > 0)
            {
                str = str.substring(0,i)+'X'+str.substring(j);
                j = i+1;
                i++;
            }
                
            // copy character at current position j 
            // to position i and increment i and j             
            if (j < str.length()) 
            {
                i++; j++;
            }
        }
        
        return str;
	}
	
	private static boolean isMatch(String str, String pattern, int strIndex)
	{
	    for (int i = 0; i < pattern.length(); i++)
	    {
	        if (str.charAt(strIndex) != pattern.charAt(i))
	            return false;
	        strIndex++;
	    }
	    
	    return true;
	}

	public static void main(String[] args) {
//		String s = "abababcdefababcdab";
//		String p = "ab";
		String s = "geeksforgeeks";
		String p = "geeks";
		String ans = replace(s, p);
		System.out.println(ans);
	}

}
