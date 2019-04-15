//Given an array of 0's and 1's your task is to complete the function maxLen which returns size of the largest sub array with equal number of 0's and 1's .
//The function maxLen takes 2 arguments. The first argument is the array A[] and second argument is the size 'N' of the array A[] .
//Example:
//Input 
//0 1 0 1
//Output
//4
//
//Time Complexity: O(n)
//Auxiliary Space: O(n)

package Medium;
import java.util.*;

public class LargestSubarrayOf0And1 {
	
	// Returns largest subarray with equal number of 0s and 1s 
	   
    int maxLen(int arr[], int n)  
    { 
        // Creates an empty hashMap hM 
   
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
  
        int sum = 0;     // Initialize sum of elements 
        int max_len = 0; // Initialize result 
        int ending_index = -1; 
  
        for (int i = 0; i < n; i++)  
        { 
            arr[i] = (arr[i] == 0) ? -1 : 1; 
        } 
  
        // Traverse through the given array    
        for (int i = 0; i < n; i++)  
        { 
            // Add current element to sum    
            sum += arr[i]; 
  
            // To handle sum=0 at last index 
   
            if (sum == 0)  
            { 
                max_len = i + 1; 
                ending_index = i; 
            } 
  
            // If this sum is seen before, then update max_len 
            // if required 
   
            if (hM.containsKey(sum + n))  
            { 
                if (max_len < i - hM.get(sum + n))  
                { 
                    max_len = i - hM.get(sum + n); 
                    ending_index = i; 
                } 
            }  
            else // Else put this sum in hash table 
                hM.put(sum + n, i); 
        } 
  
        for (int i = 0; i < n; i++)  
        { 
            arr[i] = (arr[i] == -1) ? 0 : 1; 
        } 
  
        int end = ending_index - max_len + 1; 
        System.out.println(end + " to " + ending_index); 
  
        return max_len; 
    } 
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
