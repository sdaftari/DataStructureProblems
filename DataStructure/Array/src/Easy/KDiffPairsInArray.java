//Example 1:
//Input: [3, 1, 4, 1, 5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of unique pairs.
// Time: O(n). Space: O(n)

package Easy;
import java.util.*;

public class KDiffPairsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            // Increment count for repeated entry if k = 0
            if (k == 0)
            {
                if (entry.getValue() >= 2)
                    count++;
            }
            else
            {
                if (map.containsKey(entry.getKey() + k))
                    count++;
            }
        }
        
        return count;
    }
}
