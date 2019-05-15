//Example 1:
//Input: A = [1,2,0,0], K = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
// Time: O(n)

package Easy;
import java.util.*;

public class AddToArrayForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> addToArrayForm(int[] A, int K) 
	{
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; i--) 
        {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }
}
