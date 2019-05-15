//Example:
//Given this linked list: 1->2->3->4->5
//For k = 2, you should return: 2->1->4->3->5
//For k = 3, you should return: 3->2->1->4->5

package Hard;

public class ReverseNodesInKGroups {
	
	public ListNode reverseKGroup(ListNode head, int k) 
	{
        ListNode begin;
        if (head == null || head.next ==null || k==1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null)
        {
            i++;
            if (i%k == 0)
            {
                begin = reverse(begin, head.next);
                head = begin.next;
            } 
            else 
                head = head.next;
        }
        return dummyhead.next;    
    }

    public ListNode reverse(ListNode begin, ListNode end)
    {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
