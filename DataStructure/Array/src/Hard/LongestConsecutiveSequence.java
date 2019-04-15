//Example:
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Time: O(n)

package Hard;
import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestConsecutive(int[] nums) 
	{
        if(nums == null || nums.length == 0) 
            return 0;
    
        Set<Integer> set = new HashSet<Integer>();

        for(int num: nums) 
            set.add(num);
        
        int max = 1;
        for(int num: nums)
        {
            //num hasn't been visited
            if(set.remove(num)) 
            {
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) 
                    val--;
                sum += num - val;
                
                val = num;
                while(set.remove(val+1)) 
                    val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
