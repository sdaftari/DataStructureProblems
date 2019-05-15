  //Example 1:
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.

// The time complexity is O(lN) where l is the length of the word and N is the total number of words in the dictionary. 
// To get the neighbors of one word, it takes 26 l. To get all neighbors, it will take at most 26lN since it only has N words and all other branches that are not in the dictionary won't be traversed.
// Space complexity is O(N) N is the total number of words in the dictionary

// Time: O(n^2)

package Medium;
import java.util.*;

public class WordLadder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord))
            return 0;
        
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        
        int len = 1;
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        // we just have to go from a word from one set to another word from another set
        while (!beginSet.isEmpty() && !endSet.isEmpty())
        {
            if (beginSet.size() > endSet.size()) 
            {
                // Swap two sets 5to keep smaller set as begin set
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<String> temp = new HashSet<>();
            for (String word : beginSet)
            {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) 
                {
                    for (char c = 'a'; c <= 'z'; c++) 
                    {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) 
                            return len + 1;

                        if (wordSet.contains(target) && !visited.contains(target)) 
                        {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            
            beginSet = temp;
            len++;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
