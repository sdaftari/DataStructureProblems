package Easy;

public class BalancedBinaryTree {
	
	public class TreeNode 
	{
		int val;
		TreeNode left;		
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        return getHeight(root) != -1;        
    }
    
    private int getHeight(TreeNode root)
    {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        if (left == -1) 
            return -1;

      int right = getHeight(root.right);
      if (right == -1) 
        return -1;

      if (Math.abs(left - right) > 1) 
        return -1;

      return 1 + Math.max(left, right);
    }

	public static void main(String[] args) {
		BalancedBinaryTree obj = new BalancedBinaryTree(); 
		TreeNode root = obj.new TreeNode(3);
		root.left = obj.new TreeNode(9);
		root.right = obj.new TreeNode(20);
		root.right.left = obj.new TreeNode(15);
		root.right.right = obj.new TreeNode(7);
		System.out.println(obj.isBalanced(root));
	}

}
