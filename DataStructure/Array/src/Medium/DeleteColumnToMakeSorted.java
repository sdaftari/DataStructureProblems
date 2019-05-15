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
        int ret = 0;
        // for each column, check if all strings are sorted
        for (int i = 0; i < A[0].length(); i++) 
        {
            if (!isSorted(A, i)) 
            	ret++;
        }
        return ret;
    }
    
    private boolean isSorted(String[] A, int col) 
    {
        // Over all strings, check if each character is in sorted order
        for (int i = 0; i < A.length - 1; ++i) 
        {
            if (A[i].charAt(col) > A[i + 1].charAt(col)) 
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		String[] A = {"ca","bb","ac"};
		DeleteColumnToMakeSorted obj = new  DeleteColumnToMakeSorted();
		System.out.println(obj.minDeletionSize(A));
	}

}
