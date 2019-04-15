//Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data. Sort the linked list according to the actual values.
//Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
//      Output: -5 -> -3 -> -2 -> 1 -> 4

package Medium;

public class AbsoluteListSorting {
	ListNode sortedList(ListNode head)
	{
		// Initialize previous and current nodes 
		ListNode prev = head; 
		ListNode curr = head.next; 
          
        // Traverse list 
        while(curr != null) 
        { 
            // If curr is smaller than prev, then 
                        // it must be moved to head 
            if(curr.val < prev.val) 
            { 
                // Detach curr from linked list 
                prev.next = curr.next; 
                  
                // Move current node to beginning 
                curr.next = head; 
                head = curr; 
                  
                // Update current 
                curr = prev; 
            } 
              
            // Nothing to do if current element is at right place 
            else
                prev = curr; 
          
            // Move current 
            curr = curr.next; 
        } 
        return head; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}