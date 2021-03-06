//Given an array containing equal number of positive and negative elements, arrange the array such that every positive element is followed by a negative element.
//Example:
//Input:
//2
//6
//-1 2 -3 4 -5 6
//4
//-3 2 -4 1
//Output:
//2 -1 4 -3 6 -5
//2 -3 1 -4
//Time Complexity: O(n) where n is number of elements in given array.
//Auxiliary Space: O(1)

package Medium;

public class AlternatePositiveNegative {
	// The main function that rearranges elements of given 
    // array.  It puts positive elements at even indexes (0, 
    // 2, ..) and negative numbers at odd indexes (1, 3, ..). 
    static void rearrange(int arr[], int n) 
    { 
        // The following few lines are similar to partition 
        // process of QuickSort.  The idea is to consider 0 
        // as pivot and divide the array around it. 
        int i = -1, temp = 0; 
        for (int j = 0; j < n; j++) 
        { 
            if (arr[j] < 0) 
            { 
                i++; 
                temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // Now all positive numbers are at end and negativexnumbers at 
        // the beginning of array. Initialize indexes for starting point 
        // of positive and negative numbers to be swapped 
        int pos = i+1, neg = 0; 
  
        // Increment the negative index by 2 and positive index by 1, i.e., 
        // swap every alternate negative number with next positive number 
        while (pos < n && neg < pos && arr[neg] < 0) 
        { 
            temp = arr[neg]; 
            arr[neg] = arr[pos]; 
            arr[pos] = temp; 
            pos++; 
            neg += 2; 
        } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
