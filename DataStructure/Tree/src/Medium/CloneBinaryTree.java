package Medium;

public class CloneBinaryTree {
	
	public static TreeNode cloneTree(TreeNode tree)
    {
        if(tree != null) 
        {
        	TreeNode cloneNode = new TreeNode(tree.val);
            cloneNode.left = cloneTree(tree.left);
            cloneNode.right = cloneTree(tree.right);
            return cloneNode;
        }
        else 
        	return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
