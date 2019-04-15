//Example 1:
//Input: s = "ab", t = "acb"
//Output: true
//Explanation: We can insert 'c' into s to get t.

package Medium;

public class OneEditDistance {
	
	public boolean isOneEditDistance(String s, String t) 
	{
        for (int i = 0; i < Math.min(s.length(), t.length()); i++)
        {
            if (s.charAt(i) != t.charAt(i))
            {
                // s has the same length as t, so the only possibility is replacing one char in s and t
                if (s.length() == t.length()) 
                    return s.substring(i + 1).equals(t.substring(i + 1));
                // t is longer than s, so the only possibility is deleting one char from t
                else if (s.length() < t.length()) 
                    return s.substring(i).equals(t.substring(i + 1));
                // s is longer than t, so the only possibility is deleting one char from s
                else 
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(s.length() - t.length()) == 1;     
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
