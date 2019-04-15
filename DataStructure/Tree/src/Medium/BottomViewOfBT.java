package Medium;
import java.util.*;

public class BottomViewOfBT {

	public void bottomView(Node root)
    {
        if (root == null) 
	        return;
	    
	    Map<Integer, Node> map = new HashMap<>();
	    Queue<Node> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();
	    
	    q.add(root);
	    cols.add(0);
	    
	    int min = 0;
	    int max = 0;
	    
	    while (!q.isEmpty())
	    {
	    	Node node = q.poll();
	    	int col = cols.poll();
	    	
	    	if (!map.containsKey(col)) 
	            map.put(col, null);
	        
	        map.put(col, node);
	        
	        if (node.left != null) 
	        {
	            q.add(node.left); 
	            cols.add(col - 1);
	            min = Math.min(min, col - 1);
	        }
	        
	        if (node.right != null) 
	        {                                              
	            q.add(node.right);
	            cols.add(col + 1);
	            max = Math.max(max, col + 1);
	        }
	    }
	    
	    for (int i = min; i <= max; i++) { 
            System.out.print(map.get(i).val + " "); 
        } 
    }
}
