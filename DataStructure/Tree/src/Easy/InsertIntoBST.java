package Easy;

public class InsertIntoBST {
	
	TreeNode insert(TreeNode root, int data)
    {
         if (root == null)
            return new TreeNode(data);
            
        if (data < root.val)
            root.left = insert(root.left, data);
        else if (data > root.val)
            root.right = insert(root.right, data);
            
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
