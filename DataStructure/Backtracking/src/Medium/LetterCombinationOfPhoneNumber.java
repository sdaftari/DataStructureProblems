//Example:
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

package Medium;
import java.util.*;

public class LetterCombinationOfPhoneNumber {

	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) 
            return new ArrayList<String>();
        
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }
    
    private void combination(String prefix, String digits, int offset, List<String> ret) 
    {        
        if (offset >= digits.length()) 
        {
            ret.add(prefix);
            return;
        }
        
        // Consider the letters for each digit and try for each combination
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) 
        {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
