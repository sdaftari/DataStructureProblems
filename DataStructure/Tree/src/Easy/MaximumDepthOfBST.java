//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.

package Easy;
import java.util.*;

public class MaximumDepthOfBST {
	
	public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode current = queue.poll();
                
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            
            depth++;
        }
        
        return depth;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
