package Medium;

public class MAxDiffBetweenNodeAndItsAncestor {
	
	int maxDiff(TreeNode root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        return Math.max(Math.max(root.val - f(root.left), root.val - f(root.right)), Math.max(maxDiff(root.left),maxDiff(root.right)));
    }
    
	int f(TreeNode root)
    {
        if(root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(f(root.left),f(root.right)));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
