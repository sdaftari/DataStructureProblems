//Given a singly linked list containing n nodes. Modify the value of first half nodes such that 1st node�s new value is equal to the last node�s value minus first node�s current value, 
// 2nd node�s new value is equal to the second last node�s value minus 2nd node�s current value, likewise for first half nodes. If n is odd then the value of the middle node remains unchanged.
//(No extra memory to be used).
//Examples:
//Input : 10 -> 4 -> 5 -> 3 -> 6
//Output : 4 -> 1 -> 5 -> 3 -> 6
//Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
//Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10

package Hard;

public class ModifyLinkedList {
	
	ListNode front, back;
    public ListNode modify(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        
        back = frontAndBackSplit(head);
        
        // reverse the 2nd(back) list 
        back = reverseList(back); 
        
        // modify the contents of 1st half     
        front = modifyTheContentsOf1stHalf(front, back); 
        
        ListNode tempBack = back;
        
        // modify the contents of 1st half     
        front = modifyTheContentsOf2ndtHalf(front, back); 
        
        // again reverse the 2nd(back) list 
        back = reverseList(tempBack); 
          
        // concatenating the 2nd list back to the end of the 1st list 
        head = concatFrontAndBackList(front, back); 
          
        // pointer to the modified list 
        return head; 
    }
    
    // perfrom the required subtraction operation on 
    // the 1st half of the linked list 
    ListNode modifyTheContentsOf1stHalf(ListNode front, ListNode back) 
    { 
    	ListNode temp = front;
        // traversing both the lists simultaneously 
        while (back != null) 
        { 
            // subtraction operation and node data 
            // modification 
            front.val = back.val - front.val; 
              
            front = front.next; 
            back = back.next; 
        } 
        
        return temp;
    } 
    
    // perfrom the required subtraction operation on 
    // the 1st half of the linked list 
    ListNode modifyTheContentsOf2ndtHalf(ListNode front, ListNode back) 
    { 
    	ListNode temp = front;
        // traversing both the lists simultaneously 
        while (back != null) 
        { 
            // subtraction operation and node data 
            // modification 
            back.val = back.val - front.val; 
              
            front = front.next; 
            back = back.next; 
        } 
        
        return temp;
    } 
      
    // function to concatenate the 2nd(back) list at the end of 
    // the 1st(front) list and returns the head of the new list 
    ListNode concatFrontAndBackList(ListNode front, ListNode back) 
    { 
    	ListNode head = front; 
          
        while (front.next != null) 
            front = front.next;     
              
        front.next = back; 
          
        return head; 
    } 
    
    /* Function to reverse the linked list */
    ListNode reverseList(ListNode head) 
    { 
    	ListNode current, prev, next; 
        current = head; 
        prev = null; 
        while (current != null) 
        { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        }     
        head = prev; 
        return head;
    } 
    
    ListNode frontAndBackSplit(ListNode head)
    {
    	ListNode slow, fast; 
      
        slow = head; 
        fast = head.next; 
          
        /* Advance 'fast' two nodes, and  
           advance 'slow' one node */
        while (fast != null) 
        { 
            fast = fast.next; 
            if (fast != null) 
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
          
         /* 'slow' is before the midpoint in the list,  
            so split it in two at that point. */
        //front = head; 
        back = slow.next; 
        slow.next = null; 
        return back;
    }

	public static void main(String[] args) {
		ModifyLinkedList obj = new ModifyLinkedList();
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(6);
		ListNode ans = obj.modify(head);
		while (ans != null)
		{
			System.out.println(ans.val + " ");
			ans = ans.next;
		}
	}

}
