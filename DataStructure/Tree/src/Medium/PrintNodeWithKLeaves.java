//Given a binary tree and a integer value K, the task is to print all nodes data in given binary tree having exactly K leaves in sub-tree rooted with them. If no node is found then print -1.
//Input:
//2
//2 1
//0 1 L 0 2 R
//4 2
//0 1 L 0 2 R 2 3 R 2 4 L
//
//Output:
//-1
//2

package Medium;

public class PrintNodeWithKLeaves {

	public int kLeaves(Node root, int k)
    {
        // Base Conditions : No leaves  
        if (root == null)  
            return 0; 
            
        // if node is leaf  
        if (root.left == null && root.right == null)  
            return 1;  
      
        // total leaves in subtree rooted with this  
        // node  
        int total = kLeaves(root.left, k) + kLeaves(root.right, k);  
      
        // Print this node if total is k  
        if (k == total)  
            System.out.print(root.val + " ");  
      
        return total; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
