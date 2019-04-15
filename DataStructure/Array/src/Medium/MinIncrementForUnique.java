//Example:
//Input: [3,2,1,2,1,7]
//Output: 6
//Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
//It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

// Sort the array.
// Compared with previous number,
// the current number need to be at least prev + 1.
// Time Complexity: O(NlogN)


package Medium;
import java.util.*;

public class MinIncrementForUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0, need = 0;
        for (int a : A) 
        {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }
}
