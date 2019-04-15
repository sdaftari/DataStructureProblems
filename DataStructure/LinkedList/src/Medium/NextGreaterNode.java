//Example 1:
//Input: [2,1,5]
//Output: [5,5,0]
//Example 2:
//Input: [2,7,4,3,5]
//Output: [7,0,5,5,0]
//Example 3:
//Input: [1,7,5,1,9,2,5,1]
//Output: [7,9,9,9,0,5,0,0]

// O(N) Time, O(N) Space

package Medium;
import java.util.*;

public class NextGreaterNode {
	
	public int[] nextLargerNodes(ListNode head) 
	{
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
