//Example 2:
//
//Input: "(a)())()"
//Output: ["(a)()()", "(a())()"]

package Hard;
import java.util.*;

public class RemoveInvalidParenthesis {

	public static void main(String[] args) {
		RemoveInvalidParenthesis obj = new RemoveInvalidParenthesis();
		System.out.println(obj.removeInvalidParentheses("(a)())()"));
	}

	public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) 
    {
        for (int stack = 0, i = last_i; i < s.length(); ++i) 
        {
            if (s.charAt(i) == par[0]) 
                stack++;
            if (s.charAt(i) == par[1]) 
                stack--;
            if (stack >= 0) 
                continue;
            //  Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.
            for (int j = last_j; j <= i; j++)
            	// To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. 
            	// However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). 
            	// Thus, we restrict ourself to remove the first ) in a series of concecutive )s. So we have a check s.charAt(j - 1) != par[1])
            	// And j == last_j is the first condition to start with checking for the invalid parenthesis
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}
