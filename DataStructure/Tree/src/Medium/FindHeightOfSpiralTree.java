package Medium;

public class FindHeightOfSpiralTree {
	// The roots are connected to leaves in form of circular LL
	public int treeHeight(Node root){
        if (root == null) 
            return 0; 
        if(root!=null&&isLeaf(root))
            return 1;
        
        /* compute the depth of each subtree */
        int lDepth = treeHeight(root.left); 
        int rDepth = treeHeight(root.right); 

        return Math.max(lDepth, rDepth) + 1;
    }
    
    public boolean isLeaf(Node node)
    {
       if(node != null && node.left != null && node.right != null 
        && node.left.right == node && node.right.left==node)
        {
            return true;
        }
       return false;
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
