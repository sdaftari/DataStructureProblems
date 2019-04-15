//Example:
//Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//Output: ["2", "4->49", "51->74", "76->99"]

package Medium;
import java.util.*;

public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
        {
            res.add(generateRange(lower, upper));
            return res;
        }
        
        if (lower == Integer.MAX_VALUE)
            return res;
        
        int next = lower;
        for (int i = 0; i < nums.length; i++)
        {
            // Number not in required range
            if (nums[i] < next)
                continue;
            
            // If the number is found, increase the next and continue
            if (nums[i] == next)
            {
                next = next+1;
                continue;
            }
            
            res.add(generateRange(next, nums[i]-1));
            
            if (nums[i] == upper)
                return res;
            
            next = nums[i] + 1;
        }
            
        //check if upper didn't overlap in the nums array
        if(next <= upper)
            res.add(generateRange(next, upper));        
        
         return res;
    }
    
    private String generateRange(long start, long end) {
        if(start == end)
            return ""+start;
        else
            return start+"->"+end;
    }
}
