//Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
//For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
//if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

package Medium;
import java.util.*;

public class SenteceSimilarity {
	
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) 
    {
        if (words1.length != words2.length) 
            return false;
        Map<String, String> map = new HashMap<>();
        for (String[]p : pairs)
        {
            String parent1 = find(map, p[0]);
            String parent2 = find(map, p[1]);
            if (!parent1.equals(parent2)) 
                map.put(parent1, parent2);
        }
            
        for (int i = 0; i < words1.length; i++)
        {
            // Gets the ultimate parent for each word
            if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i]))) 
                return false;
        }
        
        return true;
    }
    
    private String find(Map<String, String> map, String word)
    {
        // every word is similar to itself, so if map does not contain that key, add that as key and value
        if (!map.containsKey(word)) 
            map.put(word, word);
        return word.equals(map.get(word)) ? word : find(map, map.get(word));
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
