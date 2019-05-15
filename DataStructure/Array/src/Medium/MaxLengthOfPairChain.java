//Example 1:
//Input: [[1,2], [2,3], [3,4]]
//Output: 2
//Explanation: The longest chain is [1,2] -> [3,4]
// O(nlog(n)) Time O(1) Space

package Medium;
import java.util.*;

public class MaxLengthOfPairChain {

	public int findLongestChain(int[][] pairs) 
	{
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) 
        {
            sum++;
            int curEnd = pairs[i][1];
            // increment i till start of next chain is less than end
            while (i+1 < n && pairs[i+1][0] <= curEnd) 
                i++;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
