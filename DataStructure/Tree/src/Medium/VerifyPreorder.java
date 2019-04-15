//Consider the following binary search tree: 
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//Example 1:
//
//Input: [5,2,6,1,3]
//Output: false
//Example 2:
//
//Input: [5,2,1,3,6]
//Output: true

// O(N) and O(N)

package Medium;
import java.util.*;

public class VerifyPreorder {

	public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder)
        {
            // The highest number should come last, 
            // so if we encounter highest number and the smaller number comes after, return false
            if (p < low)
                return false;
            
            // If current element is greater than stack top, we are tracing right side elements
            // So pop stack elements and replace low
            while (!path.isEmpty() && p > path.peek())
                low = path.pop();
            // Add all smaller elements from left to stack
            path.push(p);
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
