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
        
        // If the value doesn ot lie between the range
        if (root.val < L) 
            return trimBST(root.right, L, R);
        if (root.val > R) 
            return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		
		root.left.right = new TreeNode(2);
		
		root.left.right.left = new TreeNode(1);
		
		TrimBST obj = new TrimBST();
		System.out.println(obj.trimBST(root, 1, 3).val);
	}

}
