// O(1) space O(n) complexity

package Medium;

public class PopulatingNextPointer {
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	// Perfect Binary Tree
	public Node connect(Node root) 
	{
        if(root == null) 
            return root;
        Node originalRoot = root;
        while(root != null)
        {
        	// Save the current node, so that once the current level is completed, we can go to left child in next level
            Node firstNode = root;
            while(root != null)
            {
                if(root.left != null) 
                    root.left.next = root.right;
                if(root.right != null && root.next != null) 
                    root.right.next = root.next.left;
                root = root.next;
            }
            
            // Go to next level
            root = firstNode.left;
        }
        
        return originalRoot;
    }
	
	public Node connectII(Node root) {
        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level
        
        while (cur != null) 
        {            
            //iterate on the current level
            while (cur != null) 
            { 
                //left child
                if (cur.left != null) 
                {
                    if (prev != null) 
                        prev.next = cur.left;
                    else 
                        head = cur.left;
                    
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) 
                {
                    if (prev != null) 
                        prev.next = cur.right;
                    else 
                        head = cur.right;
                    
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
        return root;
    }

	public static void main(String[] args) {
	}

}
