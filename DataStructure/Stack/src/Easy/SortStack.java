//Stack elements before sorting:
//-3 14 18 -5 30 
//
//Stack elements after sorting:
//30 18 14 -3 -5 

package Easy;
import java.util.*;

public class SortStack {
	
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!s.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = s.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
                s.push(tmpStack.pop()); 
            } 
              
            // push temp in temporary of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		SortStack obj = new SortStack();
		Stack<Integer> ans = obj.sort(s);
		while (!ans.isEmpty())
			System.out.print(ans.pop() + " ");
			
	}

}
