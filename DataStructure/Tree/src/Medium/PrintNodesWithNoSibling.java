package Medium;
import java.util.*;

public class PrintNodesWithNoSibling {
	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return a - b;});
	void printSibling(Node node)
	{
	    sibing(node);
	    if (pq.size() == 0)
	        System.out.print("-1");
	    else
	    {
	        int size = pq.size();
    	    for (int i = 0; i < size; i++)
    	        System.out.print(pq.poll() + " ");
	    }
	}
	
	void sibing(Node node)
	{
	    // Base case 
        if (node == null) 
          return; 
       
        // If this is an internal node, recur for left 
        // and right subtrees 
        if (node.left != null && node.right != null) 
        { 
            sibing(node.left); 
            sibing(node.right); 
        } 
       
        // If left child is NULL and right is not, print right child 
        // and recur for right child 
        else if (node.right != null) 
        { 
            pq.add(node.right.val);
            //System.out.print(node.right.data + " "); 
            sibing(node.right); 
        } 
       
        // If right child is NULL and left is not, print left child 
        // and recur for left child 
        else if (node.left != null) 
        { 
            pq.add(node.left.val);
            //System.out.print( node.left.data + " "); 
            sibing(node.left); 
        } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
