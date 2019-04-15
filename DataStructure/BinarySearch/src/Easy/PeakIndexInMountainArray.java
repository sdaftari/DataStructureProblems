// Example:
//Input: [0,2,1,0]
//Output: 1
//
//Time: O(logn)

package Easy;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (A[mid] < A[mid + 1]) 
                l = mid;
            else if (A[mid - 1] > A[mid]) 
                r = mid;
            else 
                return mid;
        }
        return 0;
    }
}
