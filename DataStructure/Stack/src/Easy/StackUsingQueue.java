package Easy;
import java.util.*;

public class StackUsingQueue {
	
	Queue<Integer> queue;
    /** Initialize your data structure here. */
    public StackUsingQueue() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
