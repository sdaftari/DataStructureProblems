//Example:
//
//Input:
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//Output:
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1

package Easy;
import java.util.*;

public class InvertBT {

	public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) 
                queue.offer(node.left);
            
            if(node.right != null) 
                queue.offer(node.right);
        }
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
