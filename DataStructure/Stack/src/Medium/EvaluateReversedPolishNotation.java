//Example 1:
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9

//Time: O(n). Space: O(n)

package Medium;
import java.util.*;

public class EvaluateReversedPolishNotation {
	
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int first, sec;
        for (String str : tokens)
        {
            if (str.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (str.equals("-"))
            {
                first = stack.pop();
                sec = stack.pop();
                stack.push(sec-first);
            }
            else if (str.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (str.equals("/"))
            {
                first = stack.pop();
                sec = stack.pop();
                stack.push(sec / first);
            }
            else
                stack.push(Integer.parseInt(str));
        }
        
        return stack.pop();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
