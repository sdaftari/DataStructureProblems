//Example: Permutation I
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]

// Permutation II
//Example:
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]

package Medium;
import java.util.*;
public class PermutationI {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		PermutationI obj = new PermutationI();
		List<List<Integer>> list = obj.permute(nums);
	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums)
    {
       if(tempList.size() == nums.length)
          list.add(new ArrayList<>(tempList));
       else
       {
          for(int i = 0; i < nums.length; i++)
          { 
        	 // element already exists, skip
             if(tempList.contains(nums[i])) 
                 continue; 
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       }
    } 

    
    // Permutation II : Input with duplicates
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used)
    {
        if(tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) 
                    continue;
                used[i] = true; 
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
