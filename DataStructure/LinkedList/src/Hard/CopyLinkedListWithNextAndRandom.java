package Hard;

public class CopyLinkedListWithNextAndRandom {

	public static void main(String[] args) {
		ListNodeRandom start = new ListNodeRandom(1);
		start.next = new ListNodeRandom(2);
	    start.next.next = new ListNodeRandom(3);
	    start.next.next.next = new ListNodeRandom(4);
	    start.next.next.next.next = new ListNodeRandom(5);
	    
	    // 1's random points to 3
	    start.random = start.next.next;
	 
	    // 2's random points to 1
	    start.next.random = start;
	 
	    // 3's and 4's random points to 5
	    start.next.next.random =
	                    start.next.next.next.next;
	    start.next.next.next.random =
	                    start.next.next.next.next;
	 
	    // 5's random points to 2
	    start.next.next.next.next.random =
	                                      start.next;
	    
	    CopyLinkedListWithNextAndRandom obj = new CopyLinkedListWithNextAndRandom();
	    ListNodeRandom res = obj.Copy(start);
	    while (res != null)
	    {
	    	System.out.print(res.val + " " + res.next.val + " " + res.random.val);
	    	System.out.println();
	    	res = res.next;
	    }
	}
	
	public ListNodeRandom Copy (ListNodeRandom head)
	{
		if (head == null)
			return head;
		
		// Create duplicate nodes using next pointers
		ListNodeRandom curr = head;
		while (curr != null)
		{
			ListNodeRandom copyNode = new ListNodeRandom(curr.val);
			copyNode.next = curr.next;
			curr.next = copyNode;
			curr = copyNode.next;
		}
		
		curr = head;
		// Adjust random pointers
 		while (curr != null)
		{
			if (curr.random != null)
				curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		
 		// *** IMP ***
		curr = head;
		ListNodeRandom newHead = curr.next;
		 
		while (curr != null)
		{
			ListNodeRandom temp = curr.next;
			curr.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			curr = curr.next;
		}
		
		return newHead;
	}
	
	// This takes less time
//	Node copyList(Node head)
//    {
//        if (head == null)
//			return head;
//		Node temp,curr=head,newNode,x=null;
//        temp=head;
//        Map<Node,Node>hm=new HashMap<Node,Node>();
//        while(temp!=null)
//        {
//            hm.put(temp,temp.arb);
//            temp=temp.next;
//        }
//        temp=head;
//        curr=new Node(head.data);
//        curr.arb=hm.get(head);
//        temp=temp.next;
//        x=curr;
//        while(temp!=null)
//        {
//            newNode=new Node(temp.data);
//            newNode.arb=hm.get(temp);
//            x.next=newNode;
//            x=x.next;
//            temp=temp.next;
//
//        }
//        return curr;
//
//    }
}

class ListNodeRandom
{
	int val;
	ListNodeRandom next;
	ListNodeRandom random;
	ListNodeRandom(){}
	ListNodeRandom(int val)
	{
		this.val = val;
	}
}
