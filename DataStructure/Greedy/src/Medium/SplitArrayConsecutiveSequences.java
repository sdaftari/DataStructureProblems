//Example 1:
//Input: [1,2,3,3,4,5]
//Output: True
//Explanation:
//You can split them into two consecutive subsequences : 
//1, 2, 3
//3, 4, 5

//O(n) Time O(n) Space

package Medium;
import java.util.*;

public class SplitArrayConsecutiveSequences {
	
	public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        
        // create a map of numbers and its frequency
        for (int i : nums) 
            freq.put(i, freq.getOrDefault(i,0) + 1);
        
        for (int i : nums)
        {
            if (freq.get(i) == 0) 
                continue;
            else if (appendfreq.getOrDefault(i,0) > 0)
            {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            }
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0)
            {
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            }
            else 
                return false;
            freq.put(i, freq.get(i) - 1);
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}