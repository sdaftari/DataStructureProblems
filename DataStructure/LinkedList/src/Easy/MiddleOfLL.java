//Example 1:
//Input: [1,2,3,4,5]
//Output: Node 3 from this list (Serialization: [3,4,5])
//The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//Note that we returned a ListNode object ans, such that:
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

package Easy;

public class MiddleOfLL {
	
	public ListNode middleNode(ListNode head) 
	{
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
