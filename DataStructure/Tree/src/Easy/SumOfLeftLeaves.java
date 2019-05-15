//Example:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

package Easy;
import java.util.*;

public class SumOfLeftLeaves {
	
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) 
        	return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) 
        {
            TreeNode node = stack.pop();
            if(node.left != null) 
            {
                // If the children are null, add the value
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) 
            {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
