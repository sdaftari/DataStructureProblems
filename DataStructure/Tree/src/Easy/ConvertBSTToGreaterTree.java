//Example:
//
//Input: The root of a Binary Search Tree like this:
//              5
//            /   \
//           2     13
//
//Output: The root of a Greater Tree like this:
//             18
//            /   \
//          20     13

package Easy;

public class ConvertBSTToGreaterTree {
	
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) 
            return null;
        
        convertBST(root.right);
        
        root.val += sum;
        sum = root.val;
        
        convertBST(root.left);
        
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
