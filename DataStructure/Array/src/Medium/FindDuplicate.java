// findDuplicate
// Input: [1,3,4,2,2]
// Output: 2
//Time: O(N). Space: O(1)

// findDuplicates
//Time: O(N). Space: In-place

package Medium;
import java.util.*;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findDuplicate(int[] nums) 
	{
        int n = nums.length;
        int slow = n;
        int fast = n;
        do
        {
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        } while (slow != fast);
        
        slow = n;
        while(slow != fast)
        {
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        
        return slow;
    }
	
	// Find all duplicates
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();   
        for (int i = 0; i < nums.length; i++)
        {
            int value = Math.abs(nums[i]);
            if (nums[value-1] < 0)
                result.add(value);
            
            // Negate the repeating value
            nums[value - 1] *= -1;
        }
        
        return result;
    }
}
