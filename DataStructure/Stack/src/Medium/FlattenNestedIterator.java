package Medium;

public class FlattenNestedIterator {
	
//	public class NestedIterator implements Iterator<Integer> {
//	    Stack<NestedInteger> stack = new Stack<>();
//	    public NestedIterator(List<NestedInteger> nestedList) {
//	        for(int i = nestedList.size() - 1; i >= 0; i--) 
//	            stack.push(nestedList.get(i));
//	    }
//
//	    @Override
//	    public Integer next() {
//	        return stack.pop().getInteger();
//	    }
//
//	    @Override
//	    public boolean hasNext() {
//	        while(!stack.isEmpty())
//	        {
//	            NestedInteger curr = stack.peek();
//	            // If its a direct number return true
//	            if (curr.isInteger())
//	                return true;

//	            stack.pop();
//	            
				// If popped element is a list, iterate over the list
//	            // Push the individual numbers on to the stack
//	            for(int i = curr.getList().size() - 1; i >= 0; i--) 
//	                stack.push(curr.getList().get(i));
//	        }
//	        return false;
//	    }
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
