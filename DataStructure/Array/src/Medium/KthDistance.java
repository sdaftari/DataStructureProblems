//Given an unsorted array A of size N that may contain duplicates. Also given a number K which is smaller than size of array. Find if array contains duplicates within k distance.
//Example:
//Input:
//4
//3 8
//1 2 3 4 1 2 3 4
//3 6
//1 2 3 1 4 5
//3 5
//1 2 3 4 5
//3 5
//1 2 3 4 4
//
//Output:
//False
//True
//False
//True
//
//Explanation:
//Testcase 1: 1 is present twice in subarray starting from 1 (0-based index) and ending at 4.

package Medium;
import java.util.*;

public class KthDistance {

	static boolean checkDuplicatesWithinK(int arr[], int k) 
    { 
        // Creates an empty hashset 
        HashSet<Integer> set = new HashSet<>(); 
  
        // Traverse the input array 
        for (int i = 0; i < arr.length; i++) 
        { 
            // If already present n hash, then we found a duplicate within k distance 
            if (set.contains(arr[i])) 
               return true; 
  
            // Add this item to hashset 
            set.add(arr[i]); 
  
            // Remove the k+1 distant item 
            if (i >= k) 
              set.remove(arr[i-k]); 
        } 
        return false; 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
