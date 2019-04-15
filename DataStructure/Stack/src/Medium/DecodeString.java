//Examples:
//
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

package Medium;
import java.util.*;

public class DecodeString {
	
	public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String res = "";
        
        int i = 0; int len = s.length();
        while (i < len)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                int count = 0;
                // Retrieve the complete number
                while (Character.isDigit(s.charAt(i)))
                {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                // Push the complete number onto a stack
                countStack.push(count);
            }
            else if (s.charAt(i) == '[')
            {    
                // push the current text onto a stack and start new text
                stack.push(res);
                res = "";
                i++;
            }
            else if (s.charAt(i) == ']')
            {
                // Pop the previously added string
                StringBuilder temp = new StringBuilder (stack.pop());
                // Get the count of new repeating part from stack
                int repeatTimes = countStack.pop();
                // Append the text
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            }
            // Concatenate the characters
            else {
                res += s.charAt(i++);            
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
