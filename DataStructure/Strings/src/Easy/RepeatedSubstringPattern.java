//Example 3:
//Input: "abcabcabcabc"
//Output: True
//Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

package Easy;

public class RepeatedSubstringPattern {
	
	public boolean repeatedSubstringPattern(String s) 
	{
        int l = s.length();
        // The length of the repeating substring must be a divisor of the length of the input string
        // Search for all possible divisor of str.length, starting for length/2
	    for(int i = l/2; i >= 1; i--)
        {
            if(l%i == 0)
            {
                // If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
                // If the repeated substring is equals to the input str return true
                int m = l/i;
                String subS = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
			    for(int j = 0; j < m; j++)
                    sb.append(subS);
                
                if(sb.toString().equals(s)) 
                    return true;
            }
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
