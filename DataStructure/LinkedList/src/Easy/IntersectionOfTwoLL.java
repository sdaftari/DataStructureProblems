//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
//There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

package Easy;

public class IntersectionOfTwoLL {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
        if(headA == null || headB == null) 
            return null;
        
        ListNode a = headA;
        ListNode b = headB;
        while (a != b)
        {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        
        return a;
    }
	
	static ListNode head1, head2; 
	/*function to get the intersection point of two linked 
    lists head1 and head2 */
    int getNode() { 
        int c1 = getCount(head1); 
        int c2 = getCount(head2); 
        int d; 
  
        if (c1 > c2) { 
            d = c1 - c2; 
            return _getIntesectionNode(d, head1, head2); 
        } else { 
            d = c2 - c1; 
            return _getIntesectionNode(d, head2, head1); 
        } 
    } 
  
    /* function to get the intersection point of two linked 
     lists head1 and head2 where head1 has d more nodes than 
     head2 */
    int _getIntesectionNode(int d, ListNode node1, ListNode node2) { 
        int i; 
        ListNode current1 = node1; 
        ListNode current2 = node2; 
        for (i = 0; i < d; i++) { 
            if (current1 == null) { 
                return -1; 
            } 
            current1 = current1.next; 
        } 
        while (current1 != null && current2 != null) 
        { 
            if (current1.val == current2.val) 
                return current1.val; 
            
            current1 = current1.next; 
            current2 = current2.next; 
        } 
  
        return -1; 
    } 
  
    /*Takes head pointer of the linked list and 
    returns the count of nodes in the list */
    int getCount(ListNode node) { 
    	ListNode current = node; 
        int count = 0; 
  
        while (current != null) { 
            count++; 
            current = current.next; 
        } 
  
        return count; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
