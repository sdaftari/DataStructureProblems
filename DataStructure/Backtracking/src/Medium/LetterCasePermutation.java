//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
//Examples:
//Input: S = "a1b2"
//Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//Input: S = "3z4"
//Output: ["3z4", "3Z4"]
//Input: S = "12345"
//Output: ["12345"]

package Medium;
import java.util.*;

public class LetterCasePermutation {
	
	public List<String> letterCasePermutation(String S) {
        List<String> ans=new ArrayList<>();
        compute(ans,S.toCharArray(),0);
        return ans;
    }
    
    public void compute(List<String> ans, char[] chars, int index)
    {
        if(index == chars.length)
            ans.add(new String(chars));
        else
        {
            if(Character.isLetter(chars[index]))
            {
                chars[index] = Character.toLowerCase(chars[index]);
                compute(ans, chars, index+1);
                chars[index] = Character.toUpperCase(chars[index]);
            }
            
            compute(ans, chars, index+1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
