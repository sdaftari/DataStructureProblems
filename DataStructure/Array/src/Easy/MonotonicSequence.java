// Time: o()

package Easy;

public class MonotonicSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) 
        {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}
