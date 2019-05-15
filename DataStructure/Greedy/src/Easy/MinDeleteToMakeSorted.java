//Example 1:
//Input: ["cba","daf","ghi"]
//Output: 1
//Explanation: 
//After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
//If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.

package Easy;

public class MinDeleteToMakeSorted {
	
	public int minDeletionSize(String[] A) {
        int ret = 0;
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
		// TODO Auto-generated method stub

	}

}
