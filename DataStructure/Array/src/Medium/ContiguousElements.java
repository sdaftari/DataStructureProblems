//Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”.
//Examples:
//
//Input : arr[] = {5, 2, 3, 6, 4, 4, 6, 6}
//Output : Yes
//The elements form a contiguous set of integers
//which is {2, 3, 4, 5, 6}.
//
//Input : arr[] = {10, 14, 10, 12, 12, 13, 15}
//Output : No
//Time Complexity: O(n).
//Auxiliary Space: O(n).

package Medium;
import java.util.*;

public class ContiguousElements {
	
	//	Insert all the elements in the hash table. Now pick the first element and keep on incrementing in its value by 1 till you find a value not present in the hash table. 
	//	Again pick the first element and keep on decrementing in its value by 1 till you find a value not present in the hash table. 
	//	Get the count of elements (obtained by this process) which are present in the hash table. If the count equals hash size print “Yes” else “No”.
	
	// Function to check whether the array  
    // contains a set of contiguous integers 
    Boolean areElementsContiguous(int arr[], int n) 
    { 
        // Storing elements of 'arr[]' in a hash table 'us' 
        HashSet<Integer> us = new HashSet<Integer>(); 
          
        for (int i = 0; i < n; i++) 
            us.add(arr[i]); 
  
        // As arr[0] is present in 'us' 
        int count = 1; 
  
        // Starting with previous smaller element of arr[0] 
        int curr_ele = arr[0] - 1; 
  
        // If 'curr_ele' is present in 'us', check if previous elements of curr_ele are present
        while (us.contains(curr_ele) == true) 
        {   
            // increment count 
            count++; 
  
            // update 'curr_ele" 
            curr_ele--; 
        } 
  
        // Starting with next greater  element of arr[0] 
        curr_ele = arr[0] + 1; 
  
        // If 'curr_ele' is present in 'us' 
        // check if next elements of curr_ele are present in array
        while (us.contains(curr_ele) == true) 
        { 
            // increment count 
            count++; 
  
            // update 'curr_ele" 
            curr_ele++; 
        } 
  
        // Returns true if array contains a set of 
        // contiguous integers else returns false 
        return (count == (us.size())); 
    } 

	public static void main(String[] args) {
		int[] arr = {10, 14, 10, 12, 12, 13, 15};
		ContiguousElements obj = new ContiguousElements();
		System.out.println(obj.areElementsContiguous(arr, arr.length));
	}

}
