//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//Example:
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6

package Hard;
import java.util.*;

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
	        public int compare(ListNode l1, ListNode l2){
	            return l1.val - l2.val;
	        }
	    });
	 
	    ListNode head = new ListNode(0);
	    ListNode p = head;
	 
	    // Offer first node of each list
	    for(ListNode firstNode: lists){
	        if(firstNode != null)
	            queue.offer(firstNode);
	    }    
	 
	    // Poll smallest node from queue and insert next node frpm the same list
	    while(!queue.isEmpty())
        {
	        ListNode n = queue.poll();
	        p.next = n;
	        p = p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
