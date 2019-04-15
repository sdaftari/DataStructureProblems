package Medium;
import java.util.*;

public class KthSmallestInBST {
	
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        // Move to leftmost node and add the nodes to stack
        while (root != null) 
          {
              st.push(root);
              root = root.left;
          }

          while (k != 0) 
          {
              // Start popping
              TreeNode n = st.pop();
              k--;
              if (k == 0) 
                  return n.val;
              
              // If the popped node has right child, go to right child
              TreeNode right = n.right;
              
              // And then push all left children
              while (right != null) 
              {
                  st.push(right);
                  right = right.left;
              }
          }

          return -1; // never hit if k is valid
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
