//Given a sorted array arr[] of size N without duplicates, and given a value x. Find the floor of x in given array. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.
//
//0
//1 2 8 10 11 12 19
//5
//1 2 8 10 11 12 19
//Output:
//-1
//1
//3
//
//Explanation:
//Testcase 1: No element less than 0 is found. So output is "-1".
//Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
//
//Time Complexity : O(Log n)

package Medium;

public class FloorInSortedArray {
	
	/* Function to get index of floor of x in 
    arr[low..high] */
    static int floorSearch(int arr[], int low,  
                            int high, int x) 
    { 
        // If low and high cross each other 
        if (low > high) 
            return -1; 
  
        // If last element is smaller than x 
        if (x >= arr[high]) 
            return high; 
  
        // Find the middle point 
        int mid = (low+high)/2; 
  
        // If middle point is floor. 
        if (arr[mid] == x) 
            return mid; 
  
        // If x lies between mid-1 and mid 
        if (mid > 0 && arr[mid-1] <= x && x < 
                                    arr[mid]) 
            return mid-1; 
  
        // If x is smaller than mid, floor 
        // must be in left half. 
        if (x < arr[mid]) 
            return floorSearch(arr, low,  
                               mid - 1, x); 
  
        // If mid-1 is not floor and x is 
        // greater than arr[mid], 
        return floorSearch(arr, mid + 1, high, 
                                         x); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
