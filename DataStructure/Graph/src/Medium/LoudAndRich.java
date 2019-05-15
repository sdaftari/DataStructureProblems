//Example 1:
//
//Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//Output: [5,5,2,5,4,5,6,7]
//Explanation: 
//answer[0] = 5.
//Person 5 has more money than 3, which has more money than 1, which has more money than 0.
//The only person who is quieter (has lower quiet[x]) is person 7, but
//it isn't clear if they have more money than person 0.
//
//answer[7] = 7.
//Among all people that definitely have equal to or more money than person 7
//(which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
//is person 7.
//
//The other answers can be filled out with similar reasoning.

package Medium;
import java.util.*;

public class LoudAndRich {
	
	HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int[] res;
    public int[] loudAndRich(int[][] richer, int[] quiet) 
    {
        int n = quiet.length;
        for (int i = 0; i < n; ++i) 
            richer2.put(i, new ArrayList<Integer>());
        
        // Keep track of richer people. Add people richer than key
        for (int[] v : richer)
            richer2.get(v[1]).add(v[0]);
        
        res = new int[n]; 
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) 
            dfs(i, quiet);
        return res;
    }
    
    int dfs(int i, int[] quiet)
    {
    	// If already visited, return
        if (res[i] >= 0)
            return res[i];
        res[i] = i;
        for (int j : richer2.get(i))
        {
            if (quiet[res[i]] > quiet[dfs(j, quiet)]) 
                res[i] = res[j];
        }
        return res[i];
    }

	public static void main(String[] args) {
		int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
		int[] quiet = {3,2,5,4,6,1,7,0};
		LoudAndRich obj = new LoudAndRich();
		int[] res = obj.loudAndRich(richer, quiet);
	}

}
