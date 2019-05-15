//Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. 
//If there is more than one possible answer, return the longest word with the smallest lexicographical order.
//If there is no answer, return the empty string.
//Example 1:
//Input: 
//words = ["w","wo","wor","worl", "world"]
//Output: "world"
//Explanation: 
//The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//Example 2:
//Input: 
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation: 
//Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

package Medium;
import java.util.*;

public class LongestWordInDictionary {
	
	public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) 
        {
        	// Since the words are sorted, check if the set contains a prefix equal to last char less than current string
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) 
            {
            	// Since we have already sorted, if the string is found, it will be lexicographically smaller
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		LongestWordInDictionary obj = new LongestWordInDictionary();
		System.out.println(obj.longestWord(words));
	}

}
