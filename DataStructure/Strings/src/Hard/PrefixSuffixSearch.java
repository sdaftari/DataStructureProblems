//Given many words, words[i] has weight i.
//Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
//Examples:
//Input:
//WordFilter(["apple"])
//WordFilter.f("a", "e") // returns 0
//WordFilter.f("b", "") // returns -1
//words has length in range [1, 15000].
//For each test case, up to words.length queries WordFilter.f may be made.
//words[i] has length in range [1, 10].
//prefix, suffix have lengths in range [0, 10].
//words[i] and prefix, suffix queries consist of lowercase letters only.

package Hard;
import java.util.*;

public class PrefixSuffixSearch {
	
	HashMap<String, List<Integer>> mapPrefix = new HashMap<>();
    HashMap<String, List<Integer>> mapSuffix = new HashMap<>();
    
    public PrefixSuffixSearch(String[] words) 
    {        
        for(int w = 0; w < words.length; w++)
        {
        	// max length of prefix and suffix will be 10 or equal to its length 
            for(int i = 0; i <= 10 && i <= words[w].length(); i++)
            {
            	// for prefix equal to length 1 to len or 10, add it in map and add word into key list
                String s = words[w].substring(0, i);
                if(!mapPrefix.containsKey(s)) 
                    mapPrefix.put(s, new ArrayList<>());
                mapPrefix.get(s).add(w);
            }
            
            for(int i = 0; i <= 10 && i <= words[w].length(); i++)
            {
            	// for suffix equal to length 1 to len or 10, add it in map and add word into key list
                String s = words[w].substring(words[w].length() - i);
                if(!mapSuffix.containsKey(s)) 
                    mapSuffix.put(s, new ArrayList<>());
                mapSuffix.get(s).add(w);
            }
        }
    }

    public int f(String prefix, String suffix) 
    {        
        if(!mapPrefix.containsKey(prefix) || !mapSuffix.containsKey(suffix)) 
            return -1;
        List<Integer> p = mapPrefix.get(prefix);
        List<Integer> s = mapSuffix.get(suffix);
        int i = p.size()-1, j = s.size()-1;
        while(i >= 0 && j >= 0)
        {
            if(p.get(i) < s.get(j)) 
                j--;
            else if(p.get(i) > s.get(j)) 
                i--;
            else 
                return p.get(i);
        }
        return -1;
    }

	public static void main(String[] args) {
		String[] words = {"apple"};
		PrefixSuffixSearch obj = new PrefixSuffixSearch(words);
		obj.f("a", "e");

	}

}
