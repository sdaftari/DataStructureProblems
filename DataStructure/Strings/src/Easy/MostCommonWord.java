//Example:
//Input: 
//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//banned = ["hit"]
//Output: "ball"
//Explanation: 
//"hit" occurs 3 times, but it is a banned word.
//"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
//Note that words in the paragraph are not case sensitive,
//that punctuation is ignored (even if adjacent to words, such as "ball,"), 
//and that "hit" isn't the answer even though it occurs more because it is banned.

package Easy;
import java.util.*;

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) 
	{
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        // Replace non character words with space, except a-z, A-Z,0-9
        String[] words = paragraph.replaceAll("\\W", " ").toLowerCase().split("\\s+");
        for (String s : words)
        {
            if (!ban.contains(s))
            {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
