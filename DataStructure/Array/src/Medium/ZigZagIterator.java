//Given two 1d vectors, implement an iterator to return their elements alternately.
//Example:
//Input:
//v1 = [1,2]
//v2 = [3,4,5,6] 
//Output: [1,3,2,4,5,6]
//Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].

package Medium;
import java.util.*;

public class ZigZagIterator {

	List<List<Integer>> list;
    Queue<Integer> buffer; 
    int i;    
    
    // 2 vectors 
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) 
    {
        this(new ArrayList<>());
        this.list.add(v1);
        this.list.add(v2);
        
    }
    
    // K vectors
    public ZigZagIterator(List<List<Integer>> list) 
    {
        this.list = list;
        this.buffer = new LinkedList<>();
        this.i = 0;
    }

    public int next() 
    {
        if(!hasNext()) 
        	return -1;
        if(!buffer.isEmpty()) 
        	return buffer.poll();
        
        // if buffer is empty, add i-th item from each list
        for(List<Integer> l : list)
        {
            if(i < l.size()) 
            	buffer.add(l.get(i));
        }
        i++;
        
        return next();
    }

    public boolean hasNext() 
    {
        if(!buffer.isEmpty()) 
        	return true;
        
        for(List<Integer> l : list)
        {
            if(i < l.size()) 
            	return true;
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
