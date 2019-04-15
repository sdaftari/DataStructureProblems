//Example 1:
//Input: 
//nums = 
//[[1,2],
// [3,4]]
//r = 1, c = 4
//Output: 
//[[1,2,3,4]]
//Explanation:
//The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

package Easy;

public class ReshapeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m)
            return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r*c; i++)
        {
            res[i/c][i%c] = nums[i/m][i%m];
        }
        
        return res;
    }
}
