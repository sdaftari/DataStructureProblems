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
	
	// Vertical Order
	public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
	    if (root == null) 
	        return res;
	    
	    //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
	    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
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
	    	
	    	if (!map.containsKey(col)) 
	            map.put(col, new PriorityQueue<Integer>());	    	
	        map.get(col).add(node.val);
	        
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
	    
	    for (int i = min; i <= max; i++) 
	    {
	    	// Add each map value (list) to res
	    	PriorityQueue<Integer> pq1 = map.get(i);
	    	List<Integer> temp = new ArrayList<>();
	    	int size = pq1.size();
	    	for (int j = 0; j < size; j++)
	    		temp.add(pq1.poll());
	        res.add(temp);
	    }
        
        return res;
    }
}
