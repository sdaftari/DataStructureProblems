//Example 1:
//Input:
//["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
//Output:  
//[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

package Medium;
import java.util.*;

public class FindDuplicateFiles {
	
	public List<List<String>> findDuplicate(String[] paths) 
	{
        List<List<String>> result = new ArrayList<List<String>>();
        int n = paths.length;
        if (n == 0) 
            return result;
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths)
        {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++)
            {
                int idx = strs[i].indexOf("(");
                // Get the contents after '('
                String content = strs[i].substring(idx);
                // Get the path before '('
                String filename = strs[0] + "/" + strs[i].substring(0, idx);
                // Get or Add the contents as key and all file paths as values
                Set<String> filenames = map.getOrDefault(content, new HashSet<String>());
                filenames.add(filename);
                map.put(content, filenames);
            }
        }
        
        for (String key : map.keySet()) 
        {
            if (map.get(key).size() > 1) 
                result.add(new ArrayList<String>(map.get(key)));
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
