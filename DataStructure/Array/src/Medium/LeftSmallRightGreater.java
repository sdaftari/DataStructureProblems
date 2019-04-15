
// To be corrected

//Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
//Example:
//Input:
//3
//4
//4 2 5 7
//3
//11 9 12
//6
//4 3 2 7 8 9
//
//Output:
//5
//-1
//7
//Explanation:
//Testcase 1 : Elements on left of 5 are smaller than 5 and on right of it are greater than 5.

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
	    for (int i=n; i>=0; i--) 
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
		int[] arr = {4, 2, 5, 7};
		LeftSmallRightGreater obj = new LeftSmallRightGreater();
		System.out.println(obj.findElement(arr, arr.length));
	}

}
