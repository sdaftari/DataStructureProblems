//Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
//Formally the function should:
//Return true if there exists i, j, k 
//such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
//Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
//Example 1:
//Input: [1,2,3,4,5]
//Output: true

package Medium;

public class IncreasingTriplet {
	
	public boolean increasingTriplet(int[] nums) 
	{
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) 
        {
        	// update small if n is smaller than both
            if (n <= small)              	
            	small = n;  
            // update big only if greater than small but smaller than big
            else if (n <= big) 
            	big = n;  
            // return if you find a number bigger than both
            else 
            	return true; 
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
