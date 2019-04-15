package Medium;

public class CopyWithRandomPointer {
	class Node 
	{
	    public int val;
	    public Node next;
	    public Node random;

	    public Node(int _val) {
	    	val = _val;
	    }

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};
	
	public Node copyRandomList(Node head) 
	{
        Node iter = head, next;
        if (head == null)
            return null;
        while(iter != null)
        {
            next = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        
        iter = head;
        while (iter != null)
        {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;
        
        while (iter != null)
        {
            next = iter.next.next;
            
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            
            iter.next = next;
            iter = next;
        }
                
        return pseudoHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
