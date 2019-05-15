//Example:
//Input: A = [1,3,5,4], B = [1,2,3,7]
//Output: 1
//Explanation: 
//Swap A[3] and B[3].  Then the sequences are:
//A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
//which are both strictly increasing.

// Time: O(n)

package Extra;

public class MinSwap {
	
	public static int minSwap(int[] A, int[] B) 
    {
        // swapRecord means for the ith element in A and B, the minimum swaps if we swap A[i] and B[i]
        // fixRecord means for the ith element in A and B, the minimum swaps if we DONOT swap A[i] and B[i]
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < A.length; i++) 
        {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) 
            {
		        // In this case, the ith manipulation should be same as the i-1th manipulation
                // fixRecord = fixRecord;
                swapRecord++;
            } 
            else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) 
            {
		        // In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } 
            else 
            {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        
        return Math.min(swapRecord, fixRecord);
    }

	public static void main(String[] args) {
		int[] A = {1,3,5,4};
		int[] B = {1,2,3,7};
		System.out.println(minSwap(A, B));
	}

}
