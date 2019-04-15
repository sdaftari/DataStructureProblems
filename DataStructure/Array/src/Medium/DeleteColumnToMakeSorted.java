//Example 1:
//Input: ["ca","bb","ac"]
//Output: 1
//Explanation: 
//After deleting the first column, A = ["a", "b", "c"].
//Now A is in lexicographic order (ie. A[0] <= A[1] <= A[2]).
//We require at least 1 deletion since initially A was not in lexicographic order, so the answer is 1.
// Time: O(MN)

package Medium;

public class DeleteColumnToMakeSorted {
	
	public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, j;
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) 
        {
            // For each string in array
            for (i = 0; i < n - 1; ++i) 
            {
                // check if same character at index j, is in increasing order
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) 
                {
                    // If not, increment res count to delete the character
                    res++;
                    break;
                }
            }
            if (i < n - 1) continue;
            for (i = 0; i < n - 1; ++i)
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sorted[i] = true;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
