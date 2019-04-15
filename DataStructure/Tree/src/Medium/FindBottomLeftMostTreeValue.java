// Given a binary tree, find the leftmost value in the last row of the tree.
//Example 2: 
//Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//Output:
//7

package Medium;
import java.util.*;

public class FindBottomLeftMostTreeValue {
	
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

	public static void main(String[] args) {
		FindBottomLeftMostTreeValue obj = new FindBottomLeftMostTreeValue();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		
		root.left.left.right = new TreeNode(2);
		System.out.println(obj.findBottomLeftValue(root));
	}

}
