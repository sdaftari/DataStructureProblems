//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
//Example 1:
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// Maximum BT II
//We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.
//Example 1:
//Input: root = [4,1,3,null,null,2], val = 5
//Output: [5,4,null,1,3,null,null,2]
//Explanation: A = [1,4,2,3], B = [1,4,2,3,5]

package Medium;

public class MaximumBT {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) 
	{
        if (nums == null) 
        	return null;
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) 
    {
        if (start > end) 
        	return null;
        
        // Get the id of max value
        int idxMax = start;
        for (int i = start + 1; i <= end; i++) 
        {
            if (nums[i] > nums[idxMax]) 
                idxMax = i;
        }
        
        TreeNode root = new TreeNode(nums[idxMax]);
        
        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);
        
        return root;
    }
    
    // Insert into Max BT
    public TreeNode insertIntoMaxTree(TreeNode root, int v) 
    {
        if(root == null)
        	return new TreeNode(v);
        if(root.val < v)
        {
            TreeNode node = new TreeNode(v);
            node.left=root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right,v);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
