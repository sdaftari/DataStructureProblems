//Example 3:
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

package Medium;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) 
	{
        // use a fast pointer j to see if character j is in the hash set or not, 
        // if not, great, add it to the hash set, move j forward and update the max length, 
        // otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length())
        {
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
            else 
                set.remove(s.charAt(i++));
        }
        
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
