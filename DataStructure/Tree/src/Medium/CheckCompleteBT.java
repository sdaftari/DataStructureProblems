package Medium;
import java.util.*;

public class CheckCompleteBT {
	public boolean isCompleteTree(TreeNode root) 
	{
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) 
        {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        
        // For a complete binary tree, there should not be any node after we met an empty one.
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
