//Example 1:
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32

// Time & space: O(n)

package Medium;

public class RangeSumBST {
	
	public class TreeNode 
	{
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rangeSumBST(TreeNode root, int L, int R) 
	{
        if (root == null) 
            return 0; // base case.
        if (root.val < L) 
            return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.val > R) 
            return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); // count in both children.
    }
}
