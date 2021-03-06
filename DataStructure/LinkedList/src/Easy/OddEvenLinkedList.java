package Easy;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) 
	{
	    if (head != null) {
	    
	        ListNode odd = head, even = head.next, evenHead = even; 
	    
	        while (even != null && even.next != null) {
	        	// even.next would take care of odd.next.next
	            odd.next = odd.next.next; 
	            even.next = even.next.next; 
	            odd = odd.next;
	            even = even.next;
	        }
	        
	        // Connect odd last node with even head
	        odd.next = evenHead; 
	    }
	    return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
