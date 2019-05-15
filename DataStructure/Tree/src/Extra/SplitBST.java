// Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, 
// while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.
// O(logn) if the input is balanced BST. Worst case is O(n) if it is not balanced.
package Extra;

public class SplitBST {

	public class TreeNode 
	{
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	// Splitted return [smaller/equal, greater] subtrees
	public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) 
        	return new TreeNode[]{null, null};
        
        TreeNode[] splitted;
        if(root.val <= V) 
        {
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        } 
        else 
        {
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            splitted[1] = root;
        }
        
        return splitted;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
