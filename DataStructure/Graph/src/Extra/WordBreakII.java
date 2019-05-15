//Example 2:
//
//Input:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//Output:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//Explanation: Note that you are allowed to reuse a dictionary word.

package Extra;
import java.util.*;

public class WordBreakII {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
    
    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map)
    {
        if (map.containsKey(s)) 
            return map.get(s);
        
        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0)
        {
            res.add("");
            return res;
        }
        for (String word : wordDict) 
        {
            if (s.startsWith(word))
            {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        
        map.put(s, res);
        return res;
    }
    
	public static void main(String[] args) {
		WordBreakII obj = new WordBreakII();
		String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		List<String> ans = obj.wordBreak(s, wordDict);
	}
}
