//Example 1:
//Input:
//[
//  "wrt",
//  "wrf",
//  "er",
//  "ett",
//  "rftt"
//]
//Output: "wertf"

package Hard;
import java.util.*;

public class AlienDictionary {

	public String alienOrder(String[] words) {
	    Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
	    Map<Character, Integer> outdegree = new HashMap<Character, Integer>();
	    String result="";
	    
	    if(words == null || words.length == 0) 
	    	return result;
	    
	    for(String s: words)
	    {
	        for(char c: s.toCharArray())
	        	outdegree.put(c,0);
	    }
	    
	    for(int i = 0; i < words.length-1; i++)
	    {
	        String cur = words[i];
	        String next = words[i+1];
	        int length = Math.min(cur.length(), next.length());
	        
	        for(int j = 0; j < length; j++)
	        {
	            char c1 = cur.charAt(j);
	            char c2 = next.charAt(j);
	            if(c1 != c2)
	            {                                            
	                Set<Character> set = new HashSet<Character>();
	                if(map.containsKey(c1)) 
	                	set = map.get(c1);
	                if(!set.contains(c2))
	                {
	                    set.add(c2);
	                    map.put(c1, set);
	                    outdegree.put(c2, outdegree.get(c2)+1);
	                }
	                
	                // Since the sequence depend on first mismatched character, break the loop after first mismatched
	                break;
	            }
	        }
	    }
	    
	    Queue<Character> q = new LinkedList<Character>();
	    for(char c: outdegree.keySet())
	    {
	    	// Add characters having no dependency on others
	        if(outdegree.get(c) == 0) 
	        	q.add(c);
	    }
	    while(!q.isEmpty())
	    {
	        char c = q.remove();
	        result += c;
	        if(map.containsKey(c))
	        {
	            for(char c2: map.get(c))
	            {
	            	outdegree.put(c2, outdegree.get(c2)-1);
	                if(outdegree.get(c2) == 0) 
	                	q.add(c2);
	            }
	        }
	    }
	    
	    if(result.length() != outdegree.size()) 
	    	return "";
	    return result;
	}
	
	public static void main(String[] args) {
		String[] words = {"za","zb","ca","cb"};
		AlienDictionary obj = new AlienDictionary();
		System.out.println(obj.alienOrder(words));
	}

}
