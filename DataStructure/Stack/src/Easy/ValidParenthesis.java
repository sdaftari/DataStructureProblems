//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false

// Valid Parenthesis String
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
//An empty string is also valid.
//
//Example 2:
//Input: "(*)"
//Output: True
//Example 3:
//Input: "(*))"
//Output: True

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
	
	public boolean checkValidString(String s) 
	{
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int start, int count) 
    {
        if (count < 0) 
            return false;
        
        for (int i = start; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (c == '(') 
                count++;
            else if (c == ')') 
            {
                if (count <= 0) 
                    return false;
                count--;
            }
            else if (c == '*') 
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
        }
        
        return count == 0;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
