//Provided an array of N integers, you need to reverse a subarray of that array. The range of this subarray is given by L and R.
//Example:
//Input:
//1
//7
//1 2 3 4 5 6 7
//2 4
//Output:
//1 4 3 2 5 6 7
//
//Explanation:
//Testcase 1: After reversing the elements in range 2 to 4 (2, 3, 4), modified array is 1, 4, 3, 2, 5, 6, 7.

package Easy;

public class ReverseSubArray {
	
	// Reverse subarray a[0..k-1] 
    static void reverse(int []a, int n, int L, int R) 
    {         
        int leftIndex = -1, rightIndex = -1;
        for (int i = 0; i < n; i++) 
        {
        	if (a[i] == L)
        		leftIndex = i;
        	if (a[i] == R)
        		rightIndex = i;
        }
        
        int k = rightIndex - leftIndex;
      
        // One by one reverse first  
        // and last elements of a[0..k-1] 
        for (int i = leftIndex; i <= k / 2; i++) 
        { 
            int tempswap = a[i];  
            a[i] = a[rightIndex];  
            a[rightIndex] = tempswap;      
            rightIndex--;
        } 
        
        for(int i = 0; i < n; i++)
        	System.out.print(a[i] + " ");
    } 

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int L = 2, R = 4;
		reverse(a, a.length, L, R);
	}

}
