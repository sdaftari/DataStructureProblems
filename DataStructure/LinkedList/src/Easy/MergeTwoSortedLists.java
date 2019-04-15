//Example:
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4

package Easy;

public class MergeTwoSortedLists {
	// This can be used for union as well, after sorting the two LL using merge sort
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
        ListNode head = new ListNode(0);
        ListNode res = head;
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                res.next = l1;
                l1 = l1.next;
            }
            else
            {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        
        if (l1 != null)
            res.next = l1;
        if (l2 != null)
            res.next = l2;
        
        return head.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
