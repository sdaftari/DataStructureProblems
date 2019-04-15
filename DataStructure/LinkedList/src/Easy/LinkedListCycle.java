//Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the second node.

package Easy;

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) 
	{
        if (head == null || head.next == null) 
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast)
        {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
