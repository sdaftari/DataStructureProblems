package Hard;

public class AVLInsertion {
	class Node{
		
		int height;
	        int data;
	        Node left,right;
		Node(int data)
	        {
			this.data = data;
			this.height = 0;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node insertToAVL(Node node,int data)
    {
        /* 1.  Perform the normal BST insertion */
        if (node == null) 
            return (new Node(data)); 
  
        if (data < node.data) 
            node.left = insertToAVL(node.left, data); 
        else if (data > node.data) 
            node.right = insertToAVL(node.right, data); 
        else // Duplicate keys not allowed 
            return node; 
  
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), 
                              height(node.right)); 
  
        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && data < node.left.data) 
            return rightRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && data > node.right.data) 
            return leftRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && data > node.left.data) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && data < node.right.data) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        /* return the (unchanged) node pointer */
        return node; 
    }
    
    Node root; 
  
    // A utility function to get the height of the tree 
    int height(Node N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
  
    // A utility function to get maximum of two integers 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 
  
    // Get Balance factor of node N 
    int getBalance(Node N) { 
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    } 
    
    Node deleteNode(Node root, int key)  
    {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key < root.data)  
            root.left = deleteNode(root.left, key);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key > root.data)  
            root.right = deleteNode(root.right, key);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null))  
            {  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Node temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.data = temp.data;  
  
                // Delete the inorder successor  
                root.right = deleteNode(root.right, temp.data);  
            }  
        }  
  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height = max(height(root.left), height(root.right)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    } 
    
    Node minValueNode(Node node)  
    {  
        Node current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
