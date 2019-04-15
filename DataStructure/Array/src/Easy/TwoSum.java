package Easy;
import java.util.*;

// Time: O(n), Space: O(n)

//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class TwoSum {

	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] nums = new int[] {2, 7, 11, 5};
		int[] res = obj.TwoSum(nums, 9);
		for (int i : res)
			System.out.print(i + " ");
	}

	private int[] TwoSum(int[] nums, int target)
	{
		int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target-nums[i]))
            {
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                return res;
            }
            
            map.put(nums[i], i);
        }
        
        return res;
	}
}
