//Example:
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]

package Medium;
import java.util.*;

public class TreeTraversals {
	
	public List<Integer> postorderTraversal(TreeNode root) 
	{
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) 
			return ans;
		
		stack.push(root);
		
		while (!stack.isEmpty()) 
		{
			TreeNode cur = stack.pop();
			ans.addFirst(cur.val);
			if (cur.left != null) 
				stack.push(cur.left);
			
			if (cur.right != null) 
				stack.push(cur.right);
		}
		return ans;
	}
	
	public List<Integer> preorderTraversal(TreeNode root) 
	{
        List<Integer> list = new LinkedList<>();
	    Stack<TreeNode> rights = new Stack<>();
        while(root != null)
        {
            // Add the root first
            list.add(root.val);
            
            // Push right child to stack
		    if (root.right != null)
                rights.push(root.right);
            
            // Move to left child
            root = root.left;
            
            // If no left child, pop the stack
            if (root == null && !rights.isEmpty())
                root = rights.pop();
        }
        
        return list;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(cur!=null || !stack.empty())
        {
            while(cur!=null)
            {
                // Add all left child to stack
                stack.add(cur);
                cur = cur.left;
            }
            // Once end is reached, pop the element
            cur = stack.pop();
            // Add to the list
            list.add(cur.val);
            // Move to right
            cur = cur.right;
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
