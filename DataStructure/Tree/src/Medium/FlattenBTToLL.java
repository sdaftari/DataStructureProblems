//Given a binary tree, flatten it to a linked list in-place.
//
//For example, given the following tree:
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//The flattened tree should look like:
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6

package Medium;
import java.util.*;

public class FlattenBTToLL {
	
	public void flatten(TreeNode root) 
	{
        if (root == null) 
        	return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty())
        {
            TreeNode curr = stk.pop();
            if (curr.right != null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            // Establish the right connection
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            // Disconnect the left connection. dont forget this!! 
            curr.left = null;  
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
