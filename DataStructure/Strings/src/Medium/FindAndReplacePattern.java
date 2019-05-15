//Example 1:
//Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//Output: ["mee","aqq"]
//Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
//"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
//since a and b map to the same letter.
// Similar to MatchPattern

package Medium;
import java.util.*;

public class FindAndReplacePattern {
	
	public List<String> findAndReplacePattern(String[] words, String pattern) 
	{
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) 
                res.add(w);
        return res;
    }
    
    public int[] F(String w)
    {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
        {
            // store character and index
            m.putIfAbsent(w.charAt(i), m.size());            
            res[i] = m.get(w.charAt(i));
        }
        
        return res;
    }

	public static void main(String[] args) {
//		String[] words = {"abc","deq","mee","aqq","dkd","ccc"}; String pattern = "abb";
		String[] words = {"abb", "abc", "xyz", "xyy"}; String pattern = "mno";
		FindAndReplacePattern obj = new FindAndReplacePattern();
		List<String> ans = obj.findAndReplacePattern(words, pattern);
		for (String s : ans)
			System.out.print(s + " ");
	}

}
