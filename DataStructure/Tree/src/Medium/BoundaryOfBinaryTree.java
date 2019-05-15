package Medium;
import java.util.*;

public class BoundaryOfBinaryTree {

	public class TreeNode 
	{
		int val;
		TreeNode left;		
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	List<Integer> nodes = new ArrayList<>(1000);
	
	// To find the boundary, we will have to first trace the left side, then the leaves from left and child children
	// at last the remaining right side from bottom to top  
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) 
            return nodes;

        // first add the root
        nodes.add(root.val);
        
        // trace the left side
        leftBoundary(root.left);
        
        // Now trace the leaves from left child 
        leaves(root.left);
        
        // then trace the leaves from right child
        leaves(root.right);
        
        // trace the right boundary
        rightBoundary(root.right);

        return nodes;
    }
    
    public void leftBoundary(TreeNode root) 
    {
    	// If root is null or it is a leaf, return 
        if(root == null || (root.left == null && root.right == null)) 
            return;
        nodes.add(root.val);
        
        // If left child is null, trace the right child
        if(root.left == null) 
            leftBoundary(root.right);
        else 
            leftBoundary(root.left);
    }
    
    public void rightBoundary(TreeNode root) 
    {
        if(root == null || (root.right == null && root.left == null)) 
            return;
        if(root.right == null)
            rightBoundary(root.left);
        else 
            rightBoundary(root.right);
        
     // add after child visit(reverse) since we have to print right boundary in reverse
        nodes.add(root.val); 
    }
    public void leaves(TreeNode root) 
    {
        if(root == null) 
            return;
        // If its a leaf, add it
        if(root.left == null && root.right == null) 
        {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
	
	public static void main(String[] args) {
		BoundaryOfBinaryTree obj = new BoundaryOfBinaryTree();
		TreeNode root = obj.new TreeNode(1);
		root.left = obj.new TreeNode(2);
		root.right = obj.new TreeNode(3);
		
		root.left.left = obj.new TreeNode(4);
		root.left.right = obj.new TreeNode(5);
		root.right.left = obj.new TreeNode(6);
		
		root.left.right.left = obj.new TreeNode(7);
		root.left.right.right = obj.new TreeNode(8);
		root.right.left.left = obj.new TreeNode(9);
		root.right.left.right = obj.new TreeNode(10);
		
		System.out.println(obj.boundaryOfBinaryTree(root));
	}

}
