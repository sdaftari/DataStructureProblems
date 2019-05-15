package Medium;
import java.util.*;

public class BuildTreeFromInorderAndPreorder {
	
	public class TreeNode 
	{
		int val;
		TreeNode left;		
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
        if (inorder.length == 0) 
            return null; 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root);
        // i will track preorder array and j will track inorder array
        int i=0, j=0;
        TreeNode node = null; 
        TreeNode cur = root; 
        while (j < inorder.length)
        {
        	// If peek and inorder is same, that means the left part is completely pushed on the stack
        	// This will pop all nodes untill, a node has right node
            if (stack.peek().val == inorder[j])
            {
            	// So pop the leftmost child and increment the j
                node = stack.pop(); 
                j++; 
            }
            // At this point, node will have the cild child pointed by preorder[i]
            // Establish the connection and make the node null. Push node on stack and increment i
            else if (node != null)
            {
                cur = new TreeNode(preorder[i]); 
                node.right = cur;
                node = null; 
                stack.push(cur); 
                i++; 
            }
            // This part will push the left on to the stack using preorder 
            else 
            {
                cur = new TreeNode(preorder[i]); 
                // set left child
                stack.peek().left = cur; 
                stack.push(cur);
                i++; 
            }
        }
        return root.left; 
    }

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		BuildTreeFromInorderAndPreorder obj = new BuildTreeFromInorderAndPreorder(); 
		TreeNode root = obj.new TreeNode(3);
		root.left = obj.new TreeNode(9);
		root.right = obj.new TreeNode(20);
		root.right.left = obj.new TreeNode(15);
		root.right.right = obj.new TreeNode(7);
		System.out.println(obj.buildTree(preorder, inorder));
	}

}
