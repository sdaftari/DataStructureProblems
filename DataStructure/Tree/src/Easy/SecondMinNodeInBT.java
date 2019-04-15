//Example 1:
//Input: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.

package Easy;

public class SecondMinNodeInBT {
	
	public int findSecondMinimumValue(TreeNode root) {
        if (root == null) 
            return -1;
        
        if (root.left == null && root.right == null) 
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        // if value same as root value, need to find the next candidate
        if (left == root.val) 
            left = findSecondMinimumValue(root.left);
        
        if (right == root.val) 
            right = findSecondMinimumValue(root.right);

        if (left != -1 && right != -1) 
            return Math.min(left, right);
        else if (left != -1) 
            return left;
        else 
            return right;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
