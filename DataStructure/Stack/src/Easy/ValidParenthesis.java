//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false

package Easy;
import java.util.*;

public class ValidParenthesis {

	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray())
        {
            if (c == '(')
			    stack.push(')');
            else if (c == '{')
			    stack.push('}');
            else if (c == '[')
			    stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
