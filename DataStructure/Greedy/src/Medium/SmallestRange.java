//Example 3:
//Input: A = [1,3,6], K = 3
//Output: 3
//Explanation: B = [4,6,3]

package Medium;
import java.util.*;

public class SmallestRange {
	
	public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n-1], mn = A[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            // Actual min difference is difference between max-k, A[i]+k, but if we alter max with max-k, it will change value of max in next iteration
            // So use difference between mx, A[i]+2k
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2*K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
