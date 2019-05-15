//The application for this implementation is to separate read & write of a queue in multi-processing. One of the stack is for read, and another is for write. 
//They only interfere each other when the former one is full or latter is empty.

package Easy;
import java.util.*;

public class ImplementQueueUsingStack {
	
	Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    

    /** Initialize your data structure here. */
    public ImplementQueueUsingStack() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
