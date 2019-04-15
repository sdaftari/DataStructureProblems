//Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root. 
//Note: The length of path between two nodes is represented by the number of edges between them.
//Example 1:
//Input:
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//Output: 2

package Easy;

public class LongestUnivaluePath {
	int len;
    public int longestUnivaluePath(TreeNode root) 
    {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }
    
    private int getLen(TreeNode node, int val) 
    {
        if (node == null) 
            return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
