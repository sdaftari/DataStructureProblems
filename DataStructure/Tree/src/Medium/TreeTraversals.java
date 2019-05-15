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
		LinkedList<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) 
			return list;
		
		stack.push(root);
		
		while (!stack.isEmpty()) 
		{
			TreeNode cur = stack.pop();
			list.addFirst(cur.val);
			if (cur.left != null) 
				stack.push(cur.left);
			
			if (cur.right != null) 
				stack.push(cur.right);
		}
		return list;
	}
	
	public List<Integer> preorderTraversal(TreeNode root) 
	{
        List<Integer> list = new LinkedList<>();
	    Stack<TreeNode> stack = new Stack<>();
        while(root != null)
        {
            // Add the root first
            list.add(root.val);
            
            // Push right child to stack
		    if (root.right != null)
		    	stack.push(root.right);
            
            // Move to left child
            root = root.left;
            
            // If no left child, pop the stack
            if (root == null && !stack.isEmpty())
                root = stack.pop();
        }
        
        return list;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root!=null || !stack.empty())
        {
            while(root!=null)
            {
                // Add all left child to stack
                stack.add(root);
                root = root.left;
            }
            // Once end is reached, pop the element
            root = stack.pop();
            // Add to the list
            list.add(root.val);
            // Move to right
            root = root.right;
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
