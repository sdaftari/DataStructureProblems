//Design a max stack that supports push, pop, top, peekMax and popMax.
//
//push(x) -- Push element x onto stack.
//pop() -- Remove the element on top of the stack and return it.
//top() -- Get the element on the top.
//peekMax() -- Retrieve the maximum element in the stack.
//popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
//Example 1:
//MaxStack stack = new MaxStack();
//stack.push(5); 
//stack.push(1);
//stack.push(5);
//stack.top(); -> 5
//stack.popMax(); -> 5
//stack.top(); -> 1
//stack.peekMax(); -> 5
//stack.pop(); -> 1
//stack.top(); -> 5

package Easy;
import java.util.*;

public class MaxStack {
	Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > tempMax)
            tempMax = x;
        stack.push(x);
        maxStack.push(tempMax);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() 
    {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != max)
        {
            temp.push(stack.pop());
            maxStack.pop();
        }
        
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) 
        {
            int x = temp.pop();
            push(x);
        }
        return max;
    }

	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.push(5); 
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.popMax());
		System.out.println(stack.top()); 
		System.out.println(stack.peekMax()); 
		System.out.println(stack.pop());
		System.out.println(stack.top()); 
	}
}