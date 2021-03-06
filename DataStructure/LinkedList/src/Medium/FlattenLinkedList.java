package Medium;

public class FlattenLinkedList {
	
	private static ListNodeFlatten head; 
	
	public static void main(String[] args) {
		head = push(head, 30);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 5);
		
		head.right = push(head.right, 20);
		head.right = push(head.right, 10);
		
		ListNodeFlatten res = flatten(head);
		
		while (res != null)
		{
			System.out.println(res.val);
			res = res.down;
		}
	}
	
	public static ListNodeFlatten merge(ListNodeFlatten a, ListNodeFlatten b)
    {
        // if first linked list is empty then second
        // is the answer
        if (a == null)     
        	return b;
 
        // if second linked list is empty then first
        // is the result
        if (b == null)      
        	return a;
 
        // compare the data members of the two lonked lists
        // and put the larger one in the result
        ListNodeFlatten result;
 
        if (a.val < b.val)
        {
            result = a;
            result.down =  merge(a.down, b);
        }
 
        else
        {
            result = b;
            result.down = merge(a, b.down);
        }
 
        return result;
    }
	
	public static ListNodeFlatten flatten(ListNodeFlatten root)
	{
		if (root == null || root.right == null)
			return root;
		
		root.right = flatten(root.right); 
		
		root = merge(root, root.right);
		
		return root;		
	}
	
	private static ListNodeFlatten push(ListNodeFlatten head_ref, int data)
	{
		ListNodeFlatten newNode = new ListNodeFlatten(data);
		
		/* 3. Make next of new Node as head */
        newNode.down = head_ref;
        
        /* 4. Move the head to point to new Node */
        head_ref = newNode;
 
        /*5. return to link it back */
        return head_ref;
	}

}

class ListNodeFlatten {
    int val;
    ListNodeFlatten right;
    ListNodeFlatten down;
    ListNodeFlatten(int x) { val = x; }
    ListNodeFlatten(){}
}
