//Example 2:
//Input: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//Output: 
//      3
//     / 
//   2   
//  /
// 1

package Easy;

public class TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) 
            return null;
        
        if (root.val < L) 
            return trimBST(root.right, L, R);
        if (root.val > R) 
            return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
