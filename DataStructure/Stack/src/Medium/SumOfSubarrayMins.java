//Example 1:
//
//Input: [3,1,2,4]
//Output: 17
//Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
//
//Time: O(n)

package Medium;
import java.util.*;

public class SumOfSubarrayMins {	

	public static void main(String[] args) {
		SumOfSubarrayMins obj = new SumOfSubarrayMins();
		System.out.println(obj.sumSubarrayMins(new int []{3, 1, 2, 4}));
	}

	public int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        
        // Gives strictly decreasing sequence from left [1,2,1,1]
        // This will give how many subarrays ending at A[i] will have A[i] as min
        for (int i = 0; i < n; i++)
        {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[] {A[i], count});
            left[i] = count;
        }
        // Gives strictly increasing sequence from right [1,3,2,1]
        // This will give how many subarrays starting at A[i] have A[i] as min
        for (int i = n-1; i >=0; i--)
        {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[] {A[i], count});
            right[i] = count;
        }
        
        // 1+2+3+....+n = n(n+1)/2
        // Total number of subarrays with A[i] as min = left[i] * right[i], because any subarray having A[i] as min can be expressed as a combination of 1 subarray from left (ending at A[i]) 
        // and 1 from right (starting from A[i]). So A[i] will appear as min in any of these combinations subarrays. Sp total will be  left[i] * right[i].
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }
}
