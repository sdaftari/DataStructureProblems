// Time: O(n)

package Medium;

public class GlobalAndLocalInversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i) 
            // Since all local inversions, are global also,  we cant have additonal global without having a local
            if (Math.abs(A[i] - i) > 1) 
                return false;
        return true;
    }
}
