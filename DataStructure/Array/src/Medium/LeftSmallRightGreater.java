//Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
//Example:
//Input:   arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
//Output:  Index of element is 4
//All elements on left of arr[4] are smaller than it
//and all elements on right are greater.// 
//Input:   arr[] = {5, 1, 4, 4};
//Output:  Index of element is -1
//Time Complexity: O(n)
//Auxiliary Space: O(n)

package Medium;

public class LeftSmallRightGreater {
	
	int findElement(int arr[], int n) 
	{ 
	    // leftMax[i] stores maximum of arr[0..i-1] 
	    int leftMax[] = new int[n+1]; 
	    leftMax[0] = Integer.MIN_VALUE; 
	  
	    // Fill leftMax[]1..n-1] 
	    for (int i = 1; i <= n; i++) 
	        leftMax[i] = Math.max(leftMax[i-1], arr[i-1]); 
	  
	    // Initialize minimum from right 
	    int rightMin = Integer.MAX_VALUE; 
	  
	    // Traverse array from right 
	    for (int i = n-1; i >= 0; i--) 
	    { 
	        // Check if we found a required element 
	        if (leftMax[i] < arr[i] && rightMin > arr[i]) 
	             return i; 
	  
	        // Update right minimum 
	        rightMin = Math.min(rightMin, arr[i]); 
	    } 
	  
	    // If there was no element matching criteria 
	    return -1; 
	} 

	public static void main(String[] args) {
		int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		LeftSmallRightGreater obj = new LeftSmallRightGreater();
		System.out.println(obj.findElement(arr, arr.length));
	}

}
