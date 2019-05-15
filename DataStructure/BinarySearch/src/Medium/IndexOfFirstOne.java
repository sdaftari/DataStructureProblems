//Given a sorted array consisting 0’s and 1’s. The task is to find the index of first ‘1’ in the given array.
//Example:
//Input:
//2
//10
//0 0 0 0 0 0 1 1 1 1
//4
//0 0 0 0
//
//Output:
//6
//-1
//
//Explanation:
//Testcase 1: First index where 1 is presented is 6.

package Medium;

public class IndexOfFirstOne {
	
	// function to find the index of first '1' 
    // binary search technique is applied 
    public static int indexOfFirstOne(int arr[], int low, int high) 
    { 
        while (low <= high) 
        { 
            int mid = (low + high) / 2; 
       
            // if true, then 'mid' is the index of first '1' 
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) 
                return mid; 
       
            // first '1' lies to the left of 'mid' 
            else if (arr[mid] == 1) 
                high = mid - 1; 
       
            // first '1' lies to the right of 'mid' 
            else
                low = mid + 1; 
        } 
       
        // 1's are not present in the array 
        return -1; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
