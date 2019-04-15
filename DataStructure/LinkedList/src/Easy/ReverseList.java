//Example:
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
package Easy;

public class ReverseList {

	public ListNode reverseList(ListNode head) 
	{
        ListNode p = null;
        ListNode temp;
        while (head != null)
        {
            temp = head.next;
            head.next = p;
            p = head;
            head = temp;
        }
        
        return p;
    }
	
	// Recursive
	public ListNode reverseListRe(ListNode head) {
        return recursiveReverseList(head, null);
    }
	
	private ListNode recursiveReverseList(ListNode cur, ListNode prev) 
	{
        if(cur == null) return null;
        
        if(cur.next == null) { // tail -> head
            cur.next = prev;
            return cur; 
        }
        
        ListNode next = cur.next;
        cur.next = prev;
        return recursiveReverseList(next, cur);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
