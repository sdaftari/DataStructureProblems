//Example 2:
//
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
//Time: O(n)

package Medium;
import java.util.*;

public class SortCharactersByFrequency {
	
	public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // For each character, add the frequency
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet())
        {
            // create bucket array, to store all characters based on frequency
            int frequency = map.get(key);
            if (bucket[frequency] == null) 
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        
        // Add the characters in reverse order
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
        {
            if (bucket[pos] != null)
            {
                for (char c : bucket[pos])
                {
                    for (int i = 0; i < map.get(c); i++)
                        sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
