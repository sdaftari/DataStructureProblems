//In a given array A[] find the maximum value of (A[i] � i) - (A[j] � j) where i is not equal to j.
//i and j vary from 0 to n-1 and N is size of input array A[].  Value of N is always greater than 1.
//Example:
//
//Input
//1
//5
//9 15 4 12 13
//
//Output
//12     
//
//Explanation
//(a[1]-1) - (a[2]-2) = (15-1)-(4-2) = 12
// Time: O(n)

package Medium;

public class MaxValue {
	// Returns maximum value of (arr[i]-i) -  
    // (arr[j]-j) 
    static int findMaxDiff(int arr[], int n)     
    { 
        if (n < 2) 
        { 
            System.out.println("Invalid "); 
            return 0; 
        } 
  
        // Find maximum of value of arr[i] - i  
        // for all possible values of i. Let  
        // this value be max_val. Find minimum 
        // of value of arr[i] - i for all 
        // possible values of i. Let this value 
        // be min_val. The difference max_val - 
        // min_v 
        int min_val = Integer.MAX_VALUE, 
            max_val = Integer.MIN_VALUE; 
          
        for (int i = 0; i < n; i++) 
        { 
            if ((arr[i]-i) > max_val) 
                max_val = arr[i] - i; 
                  
            if ((arr[i]-i) < min_val) 
                min_val = arr[i]-i; 
        } 
  
        return (max_val - min_val); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
