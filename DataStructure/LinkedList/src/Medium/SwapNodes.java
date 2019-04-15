package Medium;

public class SwapNodes {

	public ListNode swapPairs(ListNode head) 
	{
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null)
        {
            ListNode first = curr.next;
            ListNode sec = curr.next.next;
            first.next = sec.next;
            curr.next = sec;
            curr.next.next = first;
            curr = curr.next.next;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
