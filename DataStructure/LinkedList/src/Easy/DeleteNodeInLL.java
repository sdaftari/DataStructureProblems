//Example 1:
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

package Easy;

public class DeleteNodeInLL {
	
	public void deleteNode(ListNode node) 
	{
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	ListNode deleteAllOccurances(ListNode head, int x)
    {
		ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;
     
        while(p.next != null){
            if(p.next.val == x){
            	ListNode next = p.next;
                p.next = next.next; 
            }else{
                p = p.next;
            }
        }
     
        return helper.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
