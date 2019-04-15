package Easy;

public class LCAOfBST {
	
	TreeNode root;
    static boolean v1 = false, v2 = false;
	
	public class TreeNode 
	{
		int val;
		TreeNode left;		
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        v1 = false; v2 = false;
        
        TreeNode lca = findLCAUtil(root, p, q);
        
        return lca;
    }
    
    private TreeNode findLCAUtil(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null)
			return null;
		
		if (root.val == p.val)
		{
			v1 = true;
			return root;
		}
		
		if (root.val == q.val)
		{
			v2 = true;
			return root;
		}
		
		TreeNode left_lca = findLCAUtil(root.left, p, q);
		TreeNode right_lca = findLCAUtil(root.right, p, q);
		
		if (left_lca != null && right_lca != null)
            return root;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
	}
    
    public static void main(String[] args) {
    	LCAOfBST obj = new LCAOfBST(); 
		TreeNode root = obj.new TreeNode(6);
		root.left = obj.new TreeNode(2);
		root.right = obj.new TreeNode(8);
		
		root.left.left = obj.new TreeNode(0);
		root.left.right = obj.new TreeNode(4);
		
		root.right.left = obj.new TreeNode(7);
		root.right.right = obj.new TreeNode(9);
		
		root.left.right.left = obj.new TreeNode(3);
		root.left.right.right = obj.new TreeNode(5);
		
		System.out.println((obj.lowestCommonAncestor(root, root.left.right, root.right.left)).val);
	}
	
}
