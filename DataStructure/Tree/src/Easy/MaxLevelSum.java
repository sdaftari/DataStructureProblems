package Easy;
import java.util.*;

public class MaxLevelSum {
	
	public static int maxLevelSum(TreeNode root)
    {
        if (root == null)
            return 0;
            
        int sumLevel = 0, maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            sumLevel = 0;
            for (int i = 0; i < size; i++)
            {
            	TreeNode curr = queue.poll();
                sumLevel += curr.val;
                    
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            
            maxSum = sumLevel > maxSum ? sumLevel : maxSum;
        }
        
        return maxSum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
