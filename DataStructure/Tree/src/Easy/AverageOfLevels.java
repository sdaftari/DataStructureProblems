//Example 1:
//Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Output: [3, 14.5, 11]
//Explanation:
//The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
		
package Easy;
import java.util.*;

public class AverageOfLevels {
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) 
        	return result;
        
        q.add(root);
        
        while(!q.isEmpty()) 
        {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) 
            {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) 
                	q.offer(node.left);
                if(node.right != null) 
                	q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
