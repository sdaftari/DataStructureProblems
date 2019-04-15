//Example:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.

package Easy;
import java.util.*;

public class MinStack {
	
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min) 
            min=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
