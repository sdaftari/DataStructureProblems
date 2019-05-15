package Hard;
import java.util.*;
public class PyramidTransition {

	public static void main(String[] args) {
		String bottom = "XYZ";
		List<String> allowed = Arrays.asList("XYD", "YZE", "DEA", "FFF");
		PyramidTransition obj = new PyramidTransition();
		System.out.println(obj.pyramidTransition(bottom, allowed));
	}

	public boolean pyramidTransition(String bottom, List<String> allowed) 
	{
        Map<String, List<String>> map = new HashMap<>();
        // Create a dictionary for allowed words with first two letters as key and rest as value
        for (String s : allowed)
        {
            // Create a dictionary with first two letter as key and remaining letter as value
            String key = s.substring(0,2);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }
        
        return helper(bottom, map);
    }
    
    private boolean helper(String bottom, Map<String, List<String>> map)
    {
        if(bottom.length() == 1) 
            return true;
        // First check if from bottom string, pair of two letters is present as key in map
        for (int i = 0; i < bottom.length()-1; i++)
        {
            // Check if dual key is present in the dictionary
            if (!map.containsKey(bottom.substring(i,i+2))) 
                return false;
        }
        
        List<String> ls = new ArrayList<>();
        // getList returns the characters on upper layer which can be used as base in next iteration
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) 
        {
            if (helper(s, map)) 
                return true;
        }
        return false;
    }
    
    private void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map)
    {
        if (idx == bottom.length() - 1)
        {
            ls.add(sb.toString());
            return;
        }
        
        // For each value of a two letter key from bottom, get the list of pyramid 
        for (String s : map.get(bottom.substring(idx, idx+2)))
        {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
