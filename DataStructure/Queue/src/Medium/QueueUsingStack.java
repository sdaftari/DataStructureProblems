package Medium;
import java.util.*;

public class QueueUsingStack {
	Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    /* The method insert to push element into the queue */
    void insert(int B)
    {
        // Move all elements from s1 to s2  
        while (!s1.isEmpty()) 
        {  
            s2.push(s1.pop()); 
        }  
  
        // Push item into s1  
        s1.push(B);  
  
        // Push everything back to s1  
        while (!s2.isEmpty())  
        {  
            s1.push(s2.pop()); 
        }  
    }
	
    
    /*The method remove which return the element popped out of the queue*/
    int remove()
    {
        // if first stack is empty  
        if (s1.isEmpty())
            return -1;
  
        // Return top of s1  
        int x = s1.peek();  
        s1.pop();  
        return x;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
