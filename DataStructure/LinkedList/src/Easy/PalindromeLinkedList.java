//Example 2:
//Input: 1->2->2->1
//Output: true

package Easy;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) 
	{
        if (head == null || head.next == null)
            return true;
        ListNode next = head, pre = head;
        while (next.next != null && next.next.next != null)
        {
            pre = pre.next;
            next = next.next.next;   
        }   
               
        pre.next = reverse(pre.next);
        pre = pre.next;
        while (pre != null)
        {
            if (head.val != pre.val)
                return false;
            pre = pre.next;
            head = head.next;
        }
        
        return true;
    }
    
    ListNode reverse(ListNode head)
    {
        ListNode pre = null, next = null;
        while(head != null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
    
 // Recursive
 	public ListNode reverseListRe(ListNode head) {
         return recursiveReverseList(head, null);
     }
 	
 	private ListNode recursiveReverseList(ListNode cur, ListNode prev) 
 	{
         if(cur == null) return null;
         
         if(cur.next == null) 
         { 
        	 // tail -> head
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
