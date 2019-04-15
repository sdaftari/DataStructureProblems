package Hard;

public class ConstructTreeFromPreorder {

	class Index  
	{ 
	    int index = 0; 
	}
	
	TreeNode root; 
    Index myindex = new Index(); 
    
    TreeNode constructTree(int n, int pre[], char preLN[])
    {
        // Initialize index as 0. Value of index is used in recursion to 
        // maintain the current index in pre[] and preLN[] arrays. 
        int index = 0; 
        
        return constructTreeUtil(pre, preLN, myindex, n, root);
    }
    
    TreeNode constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n, TreeNode temp) 
    {
        // store the current value of index in pre[] 
        int index = index_ptr.index;  
   
        // Base Case: All nodes are constructed 
        if (index == n) 
            return null; 
   
        // Allocate memory for this node and increment index for 
        // subsequent recursive calls 
        temp = new TreeNode(pre[index]); 
        (index_ptr.index)++; 
   
        // If this is an internal node, construct left and right subtrees  
        // and link the subtrees 
        if (preLN[index] == 'N')  
        { 
            temp.left = constructTreeUtil(pre, preLN, index_ptr, n,  
                                                               temp.left); 
            temp.right = constructTreeUtil(pre, preLN, index_ptr, n,  
                                                               temp.right); 
        } 
   
        return temp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
