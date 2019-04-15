//Example:
//
//Input: s = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: the subarray [4,3] has the minimal length under the problem constraint.

// Time: O(n log n)

package Medium;

public class MinSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] arr) {           
        
        int[] sums = new int[arr.length + 1];
        
        // Save the sums of numbers
        // Since all elements are positive, the cumulative sum must be strictly increasing.       
        for (int i = 1; i < sums.length; i++) 
            sums[i] = sums[i - 1] + arr[i - 1]; 
        
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++)
        {
            int end = binarySearch(i+1, sums.length-1, sums[i] + s, sums);
            if (end == sums.length)
                break;
            // Now, a subarray sum can expressed as the difference between two cumulative sum.
            if (end - i < minLen) 
                minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) 
    {
        while (lo <= hi) 
        {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key)
               hi = mid - 1;
           else 
               lo = mid + 1;
        }
        return lo;
    }
}
