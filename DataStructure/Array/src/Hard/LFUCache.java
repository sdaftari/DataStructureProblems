//Example:
//
//LFUCache cache = new LFUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.get(3);       // returns 3.
//cache.put(4, 4);    // evicts key 1.
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4

package Hard;
import java.util.*;

public class LFUCache {
	HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) 
    {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) 
    {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        // increment the count
        counts.put(key, count+1);
        // remove original count
        lists.get(count).remove(key);
        // If the removed key had min count, increment the cmin
        if(count == min && lists.get(count).size()==0)
            min++;
        // Add the new key to lists
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void set(int key, int value) 
    {
        if(cap <= 0)
            return;
        if(vals.containsKey(key)) 
        {
            vals.put(key, value);
            // updates the count map
            get(key);
            return;
        } 
        if(vals.size() >= cap) 
        {
        	// get the least frequently used 
            int evit = lists.get(min).iterator().next();
            // remove from lists
            lists.get(min).remove(evit);
            // remove from vals
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}