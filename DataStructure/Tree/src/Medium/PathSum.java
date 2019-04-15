// PathSum I
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

//PathSum II
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
//Return:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
//You are given a binary tree in which each node contains an integer value. Find the number of paths that sum to a given value.The path does not need to start or end at the root or a leaf, 
//but it must go downwards (traveling only from parent nodes to child nodes). The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//Example:
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//Return 3. The paths that sum to 8 are:
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11

package Medium;
import java.util.*;

public class PathSum {
	// Path Sum I
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) 
            return false;
        
        if(root.left == null && root.right == null && sum - root.val == 0) 
            return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	// Path Sum II
	public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root, sum, currentResult, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result)
    {
        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) 
        {
            result.add(new LinkedList<>(currentResult));
            //don't forget to remove the last integer
            currentResult.remove(currentResult.size() - 1);
            return;
        } 
        else 
        {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
    
    // Path Sum III
    public int pathSumIII(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum)
    {
        if (root == null)
            return 0;
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		root.left.left.left = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		PathSum obj = new PathSum();
		obj.pathSumII(root, 22);
	}

}
