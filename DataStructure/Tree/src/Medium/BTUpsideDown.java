//Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
//flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
//Example:
//Input: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//Output: return the root of the binary tree [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
   
package Medium;

public class BTUpsideDown {
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        // Suppose if curr = 2, pre = 1, temp = 3 and next = 4
        while(curr != null) 
        {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;            
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
