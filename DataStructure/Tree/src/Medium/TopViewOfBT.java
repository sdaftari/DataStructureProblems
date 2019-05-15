package Medium;
import java.util.*;

public class TopViewOfBT {
	
	public void printTopView(TreeNode root)
    {
        if (root == null) 
	        return;
	    
	    Map<Integer, TreeNode> map = new LinkedHashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();
	    
	    q.add(root);
	    cols.add(0);
	    
	    int min = 0;
	    int max = 0;
	    
	    while (!q.isEmpty())
	    {
	    	TreeNode node = q.poll();
	    	int col = cols.poll();
	    	
	    	// Add value for  first col key only for toop view
	    	if (!map.containsKey(col)) 
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
	    
	    for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) { 
            System.out.print(entry.getValue().val + " "); 
        } 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
