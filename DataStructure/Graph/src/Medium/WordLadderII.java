//Example 1:
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]

package Medium;
import java.util.*;

public class WordLadderII {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
	{
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) 
            return res;
        
        // getChildren return map of a begin word as key and all reachable words as values
        Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, map, res, path);
        return res;
    }
    
    public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) 
    {
        if (beginWord.equals(endWord)) 
            res.add(new ArrayList<>(path));
        
        if (!map.containsKey(beginWord)) 
            return;
        
        for (String next : map.get(beginWord)) 
        {
            path.add(next);
            findLadders(next, endWord, map, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) 
    {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        Set<String> start = new HashSet<>();
        start.add(beginWord);        
        
        Set<String> end = new HashSet<>();        
        end.add(endWord);
        
        boolean found = false;
        
        // This flag helps to create a map of parent and children (obtained by replacing just one character) 
        boolean isBackward = false;
        
        while (!start.isEmpty() && !found) 
        {
        	// Since we are traversing over start set, we are considering it smaller set
            if (start.size() > end.size()) 
            {
                Set<String> tem = start;
                start = end;
                end = tem;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>();
            for (String cur : start) 
            {
                visited.add(cur);
                // getNext return words present in word list  by replacing each character in begin word 
                for (String next : getNext(cur, dict)) 
                {
                    if (visited.contains(next) || start.contains(next)) 
                        continue;
                    
                    // If complete sequences is found, found flag will be set to true. So no need to traverse after that
                    if (end.contains(next))
                        found = true;
                    
                    set.add(next);
                   
                    String parent = isBackward ? next : cur;
                    String child = isBackward ? cur : next;
                    
                    if (!map.containsKey(parent)) 
                        map.put(parent, new ArrayList<>());
                    
                    map.get(parent).add(child);
                    
                }
            }
            start = set;
        }
        return map;
        
    }
    private List<String> getNext(String cur, Set<String> dict) 
    {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) 
        {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) 
            {
                if (c == old) 
                    continue;
                
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) 
                    res.add(next);
            }
            chars[i] = old;
        }
        return res;
    }

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		WordLadderII obj = new WordLadderII();
		List<String> input = Arrays.asList(wordList);
		obj.findLadders(beginWord, endWord, input);
	}

}
