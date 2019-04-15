//Example:
//
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Valid for both SubsetsI (Input withOUT duplicates) and II (Input with duplicates). 

package Medium;
import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		subsetUtil(res, temp, nums, 0);
		return res;
    }
    
	private void subsetUtil(List<List<Integer>> res, List<Integer> temp, int[] nums, int start)
	{
		res.add(new ArrayList<> (temp));
		for (int i = start; i < nums.length; i++)
		{
			if (i > start && nums[i] == nums[i-1])
				continue;
			temp.add(nums[i]);
			subsetUtil(res, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
