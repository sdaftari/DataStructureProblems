//For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8, then your function should create and return a third list as 2->4->6.

package Medium;
	
// A linked list node
class Node
{
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
};

public class SortedIntersection 
{
	// Helper function to print given linked list
	public static void printList(String msg, Node head)
	{
		System.out.print(msg);

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	// Compute a new sorted list that represents the intersection
	// of the two given sorted lists without using dummy node
	public static Node SortedIntersect(Node a, Node b)
	{
		Node head = null, tail = null;

		// Once one or the other list runs out -- we're done
		while (a != null && b != null)
		{
			if (a.data == b.data)
			{
				if (head == null) 
					tail = head = new Node(a.data, head);
				else 
				{
					tail.next = new Node(a.data, tail.next);
					tail = tail.next;
				}

				a = a.next;
				b = b.next;
			}

			// advance the smaller list
			else if (a.data < b.data)
				a = a.next;
			else
				b = b.next;
		}
		return head;
	}

	public static void main(String[] args)
	{
		// input keys
		int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Node a = null;
		for (int i = keys.length - 1; i >= 0; i = i - 3) {
			a = new Node(keys[i], a);
		}

		Node b = null;
		for (int i = keys.length - 1; i >= 0; i = i - 2) {
			b = new Node(keys[i], b);
		}

		// print both linked list
		printList("First List  : ", a);
		printList("Second List : ", b);

		Node head = SortedIntersect(a, b);
		printList("After Intersection : ", head);
	}


	// Non sorted
	ListNode head;
	void getIntersection(ListNode head1, ListNode head2) 
    { 
		//ListNode result = null; 
		ListNode t1 = head1; 
  
        // Traverse list1 and search each element of it in list2. 
	    // If the element is present in list 2, then insert the 
	    // element to result 
	    while (t1 != null) 
	    { 
	        if (isPresent(head2, t1.val)) 
	            push(t1.val); 
	        t1 = t1.next; 
	    } 
	}

	/* A utilty function that returns true if data is present 
	in linked list  else return false */
	 boolean isPresent (ListNode head, int data) 
	 { 
		 ListNode t = head; 
	     while (t != null) 
	     { 
	         if (t.val == data) 
	             return true; 
	         t = t.next; 
	     } 
	     return false; 
	 } 
 
    /*  Inserts a node at start of linked list */
    void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
    	ListNode new_node = new ListNode(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
}
