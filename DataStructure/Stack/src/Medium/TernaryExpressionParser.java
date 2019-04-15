// Time: O(n)

//Input: "T?2:3"
//Output: "2"
//Explanation: If true, then result is 2; otherwise result is 3.

package Medium;
import java.util.*;

public class TernaryExpressionParser {
	
	public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0)
            return "";
        Deque<Character> stack = new LinkedList<>();
        
        for (int i = expression.length() - 1; i >= 0; i--)
        {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?')
            {
                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();
                if (c == 'T') 
                    stack.push(first);
                else 
                    stack.push(second);
            }
            else
                stack.push(c);
        }
        
        return String.valueOf(stack.peek());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
