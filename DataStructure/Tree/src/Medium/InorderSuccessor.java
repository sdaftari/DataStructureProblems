//Example 1:
//Input: root = [2,1,3], p = 1
//Output: 2
//Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.

// O(h) time and O(1) space

package Medium;

public class InorderSuccessor {
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
	{
		TreeNode succ = null;
		while (root != null)
		{		
			if (root.val > p.val)
			{
				succ = root;
				root = root.left;
			}
			else
				root = root.right;
		}
		
		return succ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
