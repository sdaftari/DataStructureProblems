//Example 2:
//
//Input: "((("
//Output: 3
//Example 3:
//
//Input: "()"
//Output: 0
//Example 4:
//
//Input: "()))(("
//Output: 4

// Time: O(n)

package Medium;

public class MinimumAddToMakeParenthesesValid {
	
	public int minAddToMakeValid(String S) {
        int count = 0, stk = 0;
        for (int i = 0; i < S.length(); ++i)
        {
            // If ( is encountered, increment stk
            if (S.charAt(i) == '(')
                stk++;
            // If ( is not encountered but ) is encountered, increment count
            else if (stk <= 0) 
                count++;
            // If ) is detected after (, decrement stk count
            else
                stk--;
        }
        
        return count + stk;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
