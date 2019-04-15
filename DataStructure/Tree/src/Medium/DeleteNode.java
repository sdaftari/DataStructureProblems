//Example:
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Given key to delete is 3. So we find the node with value 3 and delete it.

package Medium;

public class DeleteNode {
	
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) 
            return null;
        
        // Need to get root as key
        if(root.val == key) 
        {
            if(root.left == null) 
                return root.right;
            else if(root.right == null) 
                return root.left;
            else 
                return findPred(root);
            
        } 
        else if(key < root.val) 
            root.left = deleteNode(root.left, key);
        else 
            root.right = deleteNode(root.right, key);
        
        return root;
    }
    
    private TreeNode findPred(TreeNode root) 
    {
        TreeNode node = root.left;
        TreeNode prev = null;
        // Here root is the node to be deleted
        // node will point to the value that 
        // And prev will point to node prev to node
        // Rightmost child of root.left will replace root
        // So it can be either direct left of root or rightmost child of root.left
        while(node.right != null) 
        {
            prev = node;
            node = node.right;
        }
        
        // Since prev is previous to node, its right will point to node.left
        // This establishes relation between node's prev and its left children before extracting node
        if(prev != null) 
            prev.right = node.left;
        
        // If its the left child replacing node, then there wont be any change in node.left and node.right will point to root.right
        // Else node.left will be root.left and node.left will be right child of prev
        node.left = root.left != node ? root.left : node.left;
        node.right = root.right;
        return node;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
