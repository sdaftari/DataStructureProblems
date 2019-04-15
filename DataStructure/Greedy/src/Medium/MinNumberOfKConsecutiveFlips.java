//In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
//Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.
//Example 1:
//Input: A = [0,1,0], K = 1
//Output: 2
//Explanation: Flip A[0], then flip A[2].

//O(N) time for one pass
//O(n) extra space.

package Medium;

public class MinNumberOfKConsecutiveFlips {
	
//	here is only one way to filp A[0],
//	and A[0] will tell us if we need to filp the range A[0] ~ A[K -1].
//	So we start from the leftmost one by one using a greedy idea to solve this problem.
	public int minKBitFlips(int[] A, int K) 
	{
		//We maintain a variable flipped and flipped = 1 iff the current bit is flipped.				
		int n = A.length, flipped = 0, res = 0;
		
		// isFlipped[i] = 1 iff we flip K consecutive bits starting at A[i].
        int[] isFlipped = new int[n];
        
        for (int i = 0; i < A.length; ++i) 
        {
            if (i >= K)         	
                flipped ^= isFlipped[i - K];
            
            // If flipped = 0 and A[i] = 0, we need to flip at A[i].
            // If flipped = 1 and A[i] = 1, we need to flip at A[i].
            if (flipped == A[i]) 
            {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int[] A = {0,0,0,1,0,1,1,0};
		int K = 3;
		MinNumberOfKConsecutiveFlips obj = new MinNumberOfKConsecutiveFlips();
		System.out.println(obj.minKBitFlips(A, K));
	}

}
