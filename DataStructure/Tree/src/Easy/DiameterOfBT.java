//Example:
//Given a binary tree 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

package Easy;

public class DiameterOfBT {
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int dia = depth(root.left) + depth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia,rdia));
        
	}
    
    public int depth(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
