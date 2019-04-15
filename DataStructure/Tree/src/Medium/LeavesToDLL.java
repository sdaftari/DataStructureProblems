package Medium;

public class LeavesToDLL {

	Node head; // will point to head of DLL   
    Node prev; // temporary pointer 
    Node convertToDLL(Node root)
    {
        if (root == null) 
            return null; 
        if (root.left == null && root.right == null)  
        { 
            if (head == null)  
            { 
                head = root; 
                prev = root; 
            }  
            else 
            { 
                prev.right = root; 
                root.left = prev; 
                prev = root; 
            } 
            return null; 
        } 
        root.left = convertToDLL(root.left); 
        root.right = convertToDLL(root.right); 
        return root; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
