//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. 
//After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night. 
//Determine the maximum amount of money the thief can rob tonight without alerting the police.
//Example 1:
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//Output: 7 
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

package Medium;

public class HouseRobberIII {
	
	public int rob(TreeNode root) 
	{
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) 
        	return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right = new TreeNode(3);
		
		root.right.right = new TreeNode(1);
		HouseRobberIII obj = new HouseRobberIII();
		obj.rob(root);

	}

}
