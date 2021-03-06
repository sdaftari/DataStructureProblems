//Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
//Example:
//Input:
//2
//5 5 9
//1 2 4 5 7
//5 6 3 4 8
//2 2 3
//0 2
//1 3
//Output:
//1 8, 4 5, 5 4
//0 3, 2 1
//
//Explanation:
//Testcase 1: (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.
//
//Time Complexity : O(nlog(n))
//Auxiliary Space : O(n)

package Easy;
import java.util.*;

public class PairsWithSum {
	
	// Function to find all pairs in both arrays 
    // whose sum is equal to given value x 
    public static void findPairs(int arr1[], int arr2[], int n, int m, int x) 
    { 
        // Insert all elements of first array in a hash 
        HashMap<Integer, Integer> s = new HashMap<Integer, Integer>(); 
          
        for (int i = 0; i < n; i ++) 
            s.put(arr1[i], 0); 
       
        // Subtract sum from second array elements one 
        // by one and check it's present in array first 
        // or not 
        for (int j = 0; j < m; j ++) 
            if (s.containsKey(x - arr2[j])) 
                System.out.println(x - arr2[j] + " " + arr2[j]);              
    } 

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 4, 5, 7};
		int[] arr2 = {5, 6, 3, 4, 8};
		findPairs(arr1, arr2, arr1.length, arr2.length, 9);
	}

}
