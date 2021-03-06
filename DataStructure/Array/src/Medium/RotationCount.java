//Given a sorted array A of size N. The array is rotated 'K' times. Find the value of 'K'. The array may contain duplicate elements.
//Example:
//Input
//2
//5
//5 1 2 3 4
//5
//1 2 3 4 5
//Output
//1
//0
//
//Explanation:
//Testcase1: 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.
//
//Time Complexity : O(Log n)
//Auxiliary Space : O(1) if we use iterative Binary Search is used (Readers can refer Binary Search article for iterative Binary Search)

package Medium;

public class RotationCount {
	
	// Returns count of rotations for an array 
    // which is first sorted in ascending order, 
    // then rotated 
    static int countRotations(int arr[], int low, 
                                       int high) 
    { 
        // This condition is needed to handle  
        // the case when array is not rotated  
        // at all 
        if (high < low) 
            return 0; 
  
        // If there is only one element left 
        if (high == low) 
            return low; 
  
        // Find mid 
        // /*(low + high)/2;*/ 
        int mid = low + (high - low)/2;  
  
        // Check if element (mid+1) is minimum 
        // element. Consider the cases like 
        // {3, 4, 5, 1, 2} 
        if (mid < high && arr[mid+1] < arr[mid]) 
            return (mid + 1); 
  
        // Check if mid itself is minimum element 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return mid; 
  
        // Decide whether we need to go to left  
        // half or right half 
        if (arr[high] > arr[mid]) 
            return countRotations(arr, low, mid - 1); 
  
        return countRotations(arr, mid + 1, high); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
