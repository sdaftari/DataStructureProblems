//Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
//
//For example, the following tree
//
//             10
//          /      \
//        -2        6
//       /   \     /  \
//     8     -4   7    5
//
//should be changed to
//
//       20(4-2+12+6)
//          /              \
//     4(8-4)      12(7+5)
//       /   \           /  \
//     0      0       0    0

package Easy;

public class SumTree {

	public void toSumTree(TreeNode root)
    {
        toSum(root);
    }
    
    int toSum(TreeNode node)  
    { 
        // Base case 
        if (node == null) 
            return 0; 
   
        // Store the old value 
        int old_val = node.val; 
   
        // Recursively call for left and right subtrees and store the sum 
        // as new value of this node 
        node.val = toSum(node.left) + toSum(node.right); 
   
        // Return the sum of values of nodes in left and right subtrees 
        // and old_value of this node 
        return node.val + old_val; 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
