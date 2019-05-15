//Implement a magic directory with buildDict, and search methods.
//For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
//For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
//
//Example 1:
//Input: buildDict(["hello", "leetcode"]), Output: Null
//Input: search("hello"), Output: False
//Input: search("hhllo"), Output: True
//Input: search("hell"), Output: False
//Input: search("leetcoded"), Output: False

package Medium;
import java.util.*;

public class MagicDictionary {
	Map<String, List<int[]>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }
    
    /** Build a dictionary through a list of words */
    // For each word in dict, for each char, remove the char and put the rest of the word as key, a pair of index of the removed char and the char as part of value list into a map. e.g.
    // "hello" -> {"ello":[[0, 'h']], "hllo":[[1, 'e']], "helo":[[2, 'l'],[3, 'l']], "hell":[[4, 'o']]}
    public void buildDict(String[] dict) 
    {
        for (String s : dict) 
        {
            for (int i = 0; i < s.length(); i++) 
            {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[] {i, s.charAt(i)};
                
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
//    During search, generate the keys as in step 1. When we see there's pair of same index but different char in the value array, we know the answer is true. e.g.
//    "healo" when remove a, key is "helo" and there is a pair [2, 'l'] which has same index but different char. Then the answer is true;
    public boolean search(String word) 
    {
        for (int i = 0; i < word.length(); i++) 
        {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) 
            {
                for (int[] pair : map.get(key)) 
                {
                    if (pair[0] == i && pair[1] != word.charAt(i)) 
                    	return true;
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
