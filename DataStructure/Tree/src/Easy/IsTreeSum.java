package Easy;

public class IsTreeSum {
	TreeNode root; 
	   
    /* A utility function to get the sum of values in tree with root 
     as root */
    int sum(TreeNode node)  
    { 
        if (node == null) 
            return 0; 
        return sum(node.left) + node.val + sum(node.right); 
    } 
    
	boolean isSumTree(TreeNode node)
	{
        int ls, rs; 
   
        /* If node is NULL or it's a leaf node then 
           return true */
        if ((node == null) || (node.left == null && node.right == null)) 
            return true; 
   
        /* Get sum of nodes in left and right subtrees */
        ls = sum(node.left); 
        rs = sum(node.right); 
   
        /* if the node and both of its children satisfy the 
           property return 1 else 0*/
        if ((node.val == ls + rs) && (isSumTree(node.left)) && (isSumTree(node.right))) 
            return true; 
   
        return false; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
