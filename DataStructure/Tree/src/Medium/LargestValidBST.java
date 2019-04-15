//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
//Note:
//A subtree must include all of its descendants.
//Example:
//Input: [10,5,15,1,8,null,7]
//
//   10 
//   / \ 
//  5  15 
// / \   \ 
//1   8   7
//
//Output: 3
//Explanation: The Largest BST Subtree in this case is the highlighted one.
//             The return value is the subtree's size, which is 3.

package Medium;

public class LargestValidBST {
	
	public class TreeNode 
	{
		int val;
		TreeNode left;		
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }
    
    private int[] largestBST(TreeNode node)
    {
    	// When node==null we return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; 
    	// since when one node is null, every parent node still can form a BST ((node.val > left[1] && node.val < right[0] this condition can be satisfied later on)
        if(node == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        
        // it returns Max, Min, node value
        // So if the node val > left's min value and node val < right's max value, its a valid BST
        if(node.val > left[1] && node.val < right[0])
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        else
        	// when a current subtree is not valid BST (else part) then we return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}; 
        	// since no parent subtree can be BST if one child subtree is not valid BST. By setting like that this condition node.val > left[1] && node.val < right[0] will never be satisfied later on
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
    }

	public static void main(String[] args) {
		LargestValidBST obj = new LargestValidBST();
		TreeNode root = obj.new TreeNode(10);
		root.left = obj.new TreeNode(5);
		root.right = obj.new TreeNode(15);
		root.left.left = obj.new TreeNode(1);
		root.left.right = obj.new TreeNode(8);
		root.right.right = obj.new TreeNode(7);
		System.out.println(obj.largestBSTSubtree(root));
	}

}
