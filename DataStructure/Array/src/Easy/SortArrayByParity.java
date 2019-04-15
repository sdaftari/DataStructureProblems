// Sort by Parity I
//Example 1:
//Input: [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// Time: O(n)

// Sort by parity II
//Example 1:
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
// Time: O(n)


package Easy;

public class SortArrayByParity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// all even numbers followed by odd numbers
	public int[] sortArrayByParity(int[] A) 
	{
        for (int i = 0, j = 0; j < A.length; j++)
        {
            if (A[j] % 2 == 0)
            {
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        
        return A;
    }
	
	// Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
	public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n)
        {
            while (i < n && A[i]%2 == 0)
                i = i+2;
            
            while (j < n && A[j]%2 == 1)
                j = j+2;
            
            if (i < n && j < n) 
                swap(A, i, j);
        }
            
            return A;
    }
    
    private void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
