//Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].
//Example:
//Input:
//1 2 3 4 7 9
//0 1 2 1 1 4
//Output:
//4 5 5 6 6 6 
//
//Time Complexity: O(mlogn + nlogn)

package Medium;
import java.util.*;

public class CountingElements {
	
	// method returns the index of largest element  
    // smaller than equal to 'x' in 'arr'. For duplicates 
    // it returns the last index of occurrence of required 
    // element. If no such element exits then it returns -1.  
    static int binary_search(int arr[], int l, int h, int x) 
    { 
        while (l <= h) 
        { 
            int mid = (l+h) / 2; 
       
            // if 'x' is greater than or equal to arr[mid],  
            // then search in arr[mid+1...h] 
            if (arr[mid] <= x) 
                l = mid + 1; 
       
            // else search in arr[l...mid-1]     
            else
                h = mid - 1;     
        } 
           
        // required index 
        return h; 
    } 
       
    // method to count for each element in 1st array, 
    // elements less than or equal to it in 2nd array 
    static void countEleLessThanOrEqual(int arr1[], int arr2[],  
                                 int m, int n) 
    { 
        // sort the 2nd array 
        Arrays.sort(arr2); 
           
        // for each element of 1st array 
        for (int i=0; i<m; i++) 
        { 
            // last index of largest element  
            // smaller than or equal to x 
            int index = binary_search(arr2, 0, n-1, arr1[i]); 
               
            // required count for the element arr1[i] 
            System.out.print((index+1) + " "); 
        } 
    } 

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 7, 9};
		int[] arr2 = {0, 1, 2, 1, 1, 4};
		countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length);
	}

}
