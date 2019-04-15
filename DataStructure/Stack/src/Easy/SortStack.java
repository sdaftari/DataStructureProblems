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
              
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
