//A sorted array is rotated at some unknown point, find the minimum element in it.
//
//Following solution assumes that all elements are distinct.
//Examples:
//
//Input: {5, 6, 1, 2, 3, 4}
//Output: 1
//
//Input: {1, 2, 3, 4}
//Output: 1
//
//Input: {2, 1}
//Output: 1
//O(Logn) 

//It turned out that duplicates can�t be handled in O(Logn) time in all cases. Thanks to Amit Jain for inputs. The special cases that cause problems are like 
//{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} and {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}. It doesn�t look possible to go to left half or right half by doing constant number of comparisons at 
//the middle. So the problem with repetition can be solved in O(n) worst case.

package Medium;

public class MinimumInSortedRotatedArray {
	
	static int findMin(int arr[], int low, int high) 
    { 
        // This condition is needed to handle the case when array 
        // is not rotated at all 
        if (high < low)  
        	return arr[0]; 
  
        // If there is only one element left 
        if (high == low) 
        	return arr[low]; 
  
        // Find mid 
        int mid = low + (high - low)/2; /*(low + high)/2;*/
  
        // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
        if (mid < high && arr[mid+1] < arr[mid]) 
            return arr[mid+1]; 
  
        // Check if mid itself is minimum element 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return arr[mid]; 
  
        // Decide whether we need to go to left half or right half 
        if (arr[high] > arr[mid]) 
            return findMin(arr, low, mid-1); 
        return findMin(arr, mid+1, high); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
