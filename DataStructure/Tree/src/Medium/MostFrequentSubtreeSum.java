//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
//
//Examples 1
//Input:
//
//  5
// /  \
//2   -3
//return [2, -3, 4], since all the values happen only once, return all of them in any order.

package Medium;
import java.util.*;
public class MostFrequentSubtreeSum {
	Map<Integer, List<TreeNode>> map = new HashMap<>();
    int max = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) 
    {
        if (root == null) 
            return new int[]{};
        
        helper(root);
        
        // Map stores sum as key and roots as value
        // First get the root for the max sum
        List<Integer> result = new ArrayList<>();
        for (int i : map.keySet()) 
        {
            if (map.get(i).size() == max) 
                result.add(i);
        }
        
        // Convert list to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) 
            res[i] = result.get(i);
        
        return res;
    }
    
    private int helper(TreeNode root) 
    {
        if (root == null) 
            return 0;
        
        int sum = 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum = root.val + left + right;
        if (!map.containsKey(sum)) 
        {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(sum, list);
        } 
        else 
            map.get(sum).add(root);
        
        max = map.get(sum).size() > max ? map.get(sum).size() : max;
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
