//Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
//Example 1:
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

// Space and Time O(N)

package Medium;
import java.util.*;

public class ValidateStackSequence {
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        for (int p : pushed)
        {
            stk.push(p);
            while (!stk.isEmpty() && stk.peek() == popped[i])
            {
                stk.pop();
                i++;
            }
        }
        
        return stk.empty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
