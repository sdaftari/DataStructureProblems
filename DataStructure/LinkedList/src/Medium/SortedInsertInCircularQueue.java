package Medium;

public class SortedInsertInCircularQueue {
	ListNode head; 
	void sortedInsert(ListNode new_node) 
    { 
		ListNode current = head; 
  
        // Case 1 of the above algo 
        if (current == null) 
        { 
            new_node.next = new_node; 
            head = new_node; 
  
        } 
  
        // Case 2 of the above algo : new value is less than head
        else if (current.val >= new_node.val) 
        { 
  
            /* If value is smaller than head's value then 
             we need to change next of last node */
            while (current.next != head) 
                current = current.next; 
  
            current.next = new_node; 
            new_node.next = head; 
            head = new_node; 
        } 
  
        // Case 3 of the above algo : new value is somewhere in middle
        else
        { 
  
            /* Locate the node before the point of insertion */
            while (current.next != head && current.next.val < new_node.val) 
                current = current.next; 
  
            new_node.next = current.next; 
            current.next = new_node; 
        } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
