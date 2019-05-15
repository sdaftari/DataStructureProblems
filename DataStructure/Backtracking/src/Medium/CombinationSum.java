// CombinationSum I: Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
// The same repeated number may be chosen from candidates unlimited number of times.
//Example:
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]

//CombinationSum II: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
// Each number in candidates may only be used once in the combination.
//Example:
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]

// Combination Sum III: Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//Example 2:
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]

package Medium;
import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		System.out.println(obj.combinationSum1(new int[] {1, 2, 3}, 4));
	}

	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(candidates);
	    backtrack1(list, new ArrayList<Integer>(), candidates, target, 0);
	    return list;
    }
    
	private void backtrack1(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
	    if (remain < 0) 
	    	return; /** no solution */
	    else if (remain == 0) 
	    	list.add(new ArrayList<>(tempList));
	    else
	    {
	        for (int i = start; i < cand.length; i++) 
	        { 
	            tempList.add(cand[i]);
	            backtrack1(list, tempList, cand, remain-cand[i], i);
	            tempList.remove(tempList.size()-1);
	        } 
	    }

	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
	   List<List<Integer>> list = new LinkedList<List<Integer>>();
	   Arrays.sort(candidates);
	   backtrack2(list, new ArrayList<Integer>(), candidates, target, 0);
	   return list;
	}

	private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) 
	{
	   
	   if(remain < 0) 
		   return; /** no solution */
	   else if(remain == 0) 
		   list.add(new ArrayList<>(tempList));
	   else{
	      for (int i = start; i < cand.length; i++) 
	      {
	         if(i > start && cand[i] == cand[i-1]) 
	        	 continue; /** skip duplicates */
	         tempList.add(cand[i]);
	         backtrack2(list, tempList, cand, remain - cand[i], i+1);
	         tempList.remove(tempList.size() - 1);
	      }
	   }
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) 
	{
	    List<List<Integer>> list = new ArrayList<>();
	    backtrack(list, new ArrayList<Integer>(), k, n, 1);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) 
	{
	    if(tempList.size() > k) 
	    	return; /** no solution */
	    else if(tempList.size() == k && remain == 0) 
	    	list.add(new ArrayList<>(tempList));
	    else{
	        for (int i = start; i <= 9; i++) 
	        {
	            tempList.add(i);
	            backtrack(list, tempList, k, remain-i, i+1);
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	
//	Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
//	Example:
//
//	nums = [1, 2, 3]
//	target = 4
//
//	The possible combination ways are:
//	(1, 1, 1, 1)
//	(1, 1, 2)
//	(1, 2, 1)
//	(1, 3)
//	(2, 1, 1)
//	(2, 2)
//	(3, 1)
	public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        // Similar to #ways to achieve the combination sum
        for (int i = 1; i < comb.length; i++) 
        {
            for (int j = 0; j < nums.length; j++) 
            {
                if (i - nums[j] >= 0) 
                    comb[i] += comb[i - nums[j]];
            }
        }
        return comb[target];
    }
}
