//You need to find the largest value in each row of a binary tree.
//
//Example:
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]

package Medium;
import java.util.*;

public class LargestValueInEachRow {
	
	public List<Integer> largestValues(TreeNode root) {
        if(root == null) 
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int max = queue.peek().val;
            for(int sz = queue.size(); sz > 0; sz --)
            {
                TreeNode temp = queue.poll();
                if(temp.left != null) 
                    queue.offer(temp.left);
                if(temp.right != null) 
                    queue.offer(temp.right);
                max = Math.max(max, temp.val);
            }
            
            res.add(max);
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
