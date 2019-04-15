package Medium;

public class CorrectBST {
	TreeNode first, middle, last, prev;
    public TreeNode correctBST(TreeNode root)
    {
        first = middle = last = prev = null;
 
        // Set the pointers to find out 
        // two nodes
        correctBSTUtil(root);
 
        // Fix (or correct) the tree
        if( first != null && last != null )
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp; 
        }
        // Adjacent nodes swapped
        else if( first != null && middle != null ) 
        {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        return root;
    }
    
    public void correctBSTUtil(TreeNode root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);
 
            // If this node is smaller than
            // the previous node, it's 
            // violating the BST rule.
            if (prev != null && root.val < prev.val)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }
 
                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }
 
            // Mark this node as previous
            prev = root;
 
            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}