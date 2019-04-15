//Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. 
//Your method will be called repeatedly many times with different parameters. 
//Example:
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//Input: word1 = “coding”, word2 = “practice”
//Output: 3
//Input: word1 = "makes", word2 = "coding"
//Output: 1


//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//word1 and word2 may be the same and they represent two individual words in the list.
//Example:
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Time: O(n) both

package Medium;
import java.util.*;

public class SHortestWordDistance {
	
	private Map<String, List<Integer>> map;

	// Class implementation of shortest distance
    public SHortestWordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            if (map.containsKey(word))
                map.get(word).add(i);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word, list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) 
        {
            int index1 = list1.get(i), index2 = list2.get(j);
            if(index1 < index2) 
            {
                ret = Math.min(ret, index2 - index1);
                i++;
            } 
            else 
            {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;     
    }
    
    // Simple implementation of shortest distance
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1; 
        int min = words.length;
        for (int i = 0; i < words.length; i++)
        {
            if (words[i].equals(word1) || words[i].equals(word2))
            {
                // If the first word has been matched
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i])))
                    min = Math.min(i - index, min);
                
                index = i;
            }
        }
        
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
