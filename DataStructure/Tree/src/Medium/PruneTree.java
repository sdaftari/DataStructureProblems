//We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
//Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//Example 1:
//Input: [1,null,0,0,1]
//Output: [1,null,0,null,1]
// 
//Explanation: 
//Only the red nodes satisfy the property "every subtree not containing a 1".


package Medium;

public class PruneTree {
	
	public TreeNode pruneTree(TreeNode root)
	{
		if (root == null)
			return null;
		
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		
		if (root.left == null && root.right == null && root.val == 0)
			return null;
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
