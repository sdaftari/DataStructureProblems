//Given a nested list of integers represented as a string, implement a parser to deserialize it.
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//Note: You may assume that the string is well-formed:
//String is non-empty.
//String does not contain white spaces.
//String contains only digits 0-9, [, - ,, ].
//Example 2:
//Given s = "[123,[456,[789]]]",
//Return a NestedInteger object containing a nested list with 2 elements:
//
//1. An integer containing value 123.
//2. A nested list containing two elements:
//    i.  An integer containing value 456.
//    ii. A nested list with one element:
//         a. An integer containing value 789.

package Medium;

public class MiniParser {
	
//	 public interface NestedInteger 
//	 {
//	      // Constructor initializes an empty nested list.
//	      public NestedInteger();
//	 
//	      // Constructor initializes a single integer.
//	      public NestedInteger(int value);
//	 
//	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
//	      public boolean isInteger();
//	 
//	      // @return the single integer that this NestedInteger holds, if it holds a single integer
//	      // Return null if this NestedInteger holds a nested list
//	      public Integer getInteger();
//	 
//	      // Set this NestedInteger to hold a single integer.
//	      public void setInteger(int value);
//	 
//	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//	      public void add(NestedInteger ni);
//	 
//	      // @return the nested list that this NestedInteger holds, if it holds a nested list
//	      // Return null if this NestedInteger holds a single integer
//	      public List<NestedInteger> getList();
//	 }
//	
//	public NestedInteger deserialize(String s) 
//    {
//        if (s.isEmpty())
//            return null;
//        if (s.charAt(0) != '[') // ERROR: special case
//            return new NestedInteger(Integer.valueOf(s));
//        
//        Stack<NestedInteger> stack = new Stack<>();
//        NestedInteger curr = null;
//        int l = 0; // l shall point to the start of a number substring; 
//                   // r shall point to the end+1 of a number substring
//        for (int r = 0; r < s.length(); r++) 
//        {
//            char ch = s.charAt(r);
//            // [ points to new start
//            if (ch == '[') 
//            {
//                // so if previous part is not null, push it to stack
//                if (curr != null) {
//                    stack.push(curr);
//                }
//                // Initialize curr again
//                curr = new NestedInteger();
//                l = r+1;
//            } 
//            else if (ch == ']') 
//            {
//                // If its immediately following the number, its the end of object
//                String num = s.substring(l, r);
//                if (!num.isEmpty())
//                    curr.add(new NestedInteger(Integer.valueOf(num)));
//               
				  // If stack is not empty, the previous list, we need to add this curr to previous list
//                if (!stack.isEmpty()) 
//                {
//                    NestedInteger pop = stack.pop();
//                    pop.add(curr);
//                    curr = pop;
//                }
//                l = r+1;
//            } 
//            else if (ch == ',') 
//            {
//                // If previous char is not ], it is not an end of list. since each input ends with ],
//                if (s.charAt(r-1) != ']') 
//                {
//                    // So retrieve the number and add it to the list
//                    String num = s.substring(l, r);
//                    curr.add(new NestedInteger(Integer.valueOf(num)));
//                }
//                l = r+1;
//            }
//        }
//
//        return curr;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
