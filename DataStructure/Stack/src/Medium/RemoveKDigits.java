//Example 1:
//
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

//Time: O(N) and Space: O(N)

package Medium;
import java.util.*;

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length())
        {
            // If stack has greater number, pop it
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i))
            {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
            i++;
        }
        
        // Remove remaining characters
        while(k > 0)
        {
            stack.pop();
            k--;            
        }
        
        // Pop remaining digits
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        // Reverse the string
        sb.reverse();
        
        // Remove first character if its 0
        while(sb.length() > 1 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
