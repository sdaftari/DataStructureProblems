package Medium;

public class DeleteNNodesAfterMNodes {
	
	// Function to skip M nodes and then 
	// delete N nodes of the linked list.  
	static void skipMdeleteN( ListNode head, int M, int N)  
	{  
		ListNode curr = head, t;  
	    int count;  
	  
	    // The main loop that traverses 
	    // through the whole list  
	    while (curr!=null)  
	    {  
	        // Skip M nodes. Since curr is already pointing to head, go from 1 to < M  
	        for (count = 1; count < M && curr != null; count++)  
	            curr = curr.next;  
	  
	        // If we reached end of list, then return  
	        if (curr == null)  
	            return;  
	  
	        // Start from next node and delete N nodes 
	        // For N, liip goes from 1 to <= N
	        t = curr.next;  
	        for (count = 1; count <= N && t != null; count++)  
	        {  
	        	//ListNode temp = t;  
	            t = t.next;  
	        }  
	          
	        // Link the previous list with remaining nodes  
	        curr.next = t;  
	  
	        // Set current pointer for next iteration  
	        curr = t;  
	    }  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
