//Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
//Example 1:
//Input: 
//root = [1, 2, 3], k = 5
//Output: [[1],[2],[3],[],[]]
//Explanation:
//The input and each element of the output are ListNodes, not arrays.
//For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
//The first element output[0] has output[0].val = 1, output[0].next = null.
//The last element output[4] is null, but it's string representation as a ListNode is [].
//Example 2:
//Input: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//Explanation:
//The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

package Hard;

public class SplitLLIntoParts {
	
	public ListNode[] splitListToParts(ListNode root, int k) 
	{
        ListNode[] parts = new ListNode[k];
        int len = 0;
        // Calculate the total length of linked list
        for (ListNode node = root; node != null; node = node.next)
            len++;
        int n = len/k, r = len%k;
        ListNode node = root, prev = null;
        // i loops over k and saves only first node of each list
        for (int i = 0; node != null && i < k; i++, r--)
        {
            parts[i] = node;  
            // This loop move forward the node n steps
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++)
            {
                prev = node;
                node = node.next;
            }
            
            // make the next of last node null
            prev.next = null;
        }
        
        return parts;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
