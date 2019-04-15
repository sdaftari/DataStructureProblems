//Given an array of integers, find length of the largest subarray with sum equals to 0.
//Examples :
//
//Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
//Output: 5
//The largest subarray with 0 sum is -2, 2, -8, 1, 7
//
//Input: arr[] = {1, 2, 3}
//Output: 0
//There is no subarray with 0 sum
//
//Input: arr[] = {1, 0, 3}
//Output: 1
//
//Time: O(n)

package Medium;
import java.util.*;

public class LongestSubarrayWithSumZero {
	
	// Returns length of the maximum length subarray with 0 sum 
    static int maxLen(int arr[]) 
    { 
        // Creates an empty hashMap hM 
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
  
        int sum = 0;      // Initialize sum of elements 
        int max_len = 0;  // Initialize result 
  
        // Traverse through the given array 
        for (int i = 0; i < arr.length; i++) 
        { 
            // Add current element to sum 
            sum += arr[i]; 
  
            if (arr[i] == 0 && max_len == 0) 
                max_len = 1; 
  
            if (sum == 0) 
                max_len = i+1; 
  
            // Look this sum in hash table 
            Integer prev_i = hM.get(sum); 
  
            // If this sum is seen before, then update max_len 
            // if required 
            if (prev_i != null) 
               max_len = Math.max(max_len, i-prev_i); 
            else  // Else put this sum in hash table 
               hM.put(sum, i); 
        } 
  
        return max_len; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}