//Example:
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
// Time: O(NlogN)
// Space: O(M+N)

package Medium;
import java.util.*;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) 
	{
        if (strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) 
        {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) 
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
