//Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
//If there is no future day for which this is possible, put 0 instead.
// For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// Time: O(n). Space: O(n)

package Medium;
import java.util.*;

public class DailyTemperature {
	
	public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();   
        int[] ret = new int[T.length];
        for(int i = 0; i < T.length; i++)
        {
            // when the greater temp is seen, take the difference between the indices
            while(!stack.isEmpty() && T[i] > T[stack.peek()])
            {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            
            // Push all the indices
            stack.push(i);
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
