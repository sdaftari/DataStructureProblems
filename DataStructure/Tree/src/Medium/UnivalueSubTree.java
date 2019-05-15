//Given a binary tree, count the number of uni-value subtrees.
//A Uni-value subtree means all nodes of the subtree have the same value.
//Example :
//Input:  root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//Output: 4

package Medium;

public class UnivalueSubTree {
	private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUnivalue(root);
        return count;
    }
    
    public boolean isUnivalue(TreeNode node){
        if(node == null) return true;
        if(isUnivalue(node.left) & isUnivalue(node.right)){
            if(node.left != null && node.left.val != node.val) return false;
            if(node.right != null && node.right.val != node.val) return false;
            count += 1;
            return true;
        }
        return false; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
