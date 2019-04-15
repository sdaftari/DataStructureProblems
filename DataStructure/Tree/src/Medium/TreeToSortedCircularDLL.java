package Medium;

public class TreeToSortedCircularDLL {

	Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        
        // Inorder
        helper(root);
        
        //connect head and tail since we need circular
        // dummy.right is head
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    
    private void helper(Node curr)
    {
        if (curr == null)
            return;
        helper(curr.left);
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        helper(curr.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
