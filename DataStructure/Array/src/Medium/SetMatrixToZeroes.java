//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//
//Example 1:
//
//Input: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//Output: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]

package Medium;

public class SetMatrixToZeroes {	
	public static void main(String[] args) {
		SetMatrixToZeroes obj = new SetMatrixToZeroes();
		//int[][] nums = new int[][] {{1,1,1}, {1,0,1}, {1,1,1}};
		int[][] nums = new int[][] {{1}, {0}};
		obj.setZeroes(nums);
	}
	
	public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++)
        {
            // if the first element in any row is 0, set col0 = 0
            if (matrix[i][0] == 0)
                col0 = 0;
            // From first col, if any element is 0, make first element of that row and col = 0
            for (int j = 1; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
            
        for (int i = rows - 1; i >= 0; i--) 
        {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            
             // Do this for upper rows
             if (col0 == 0) 
                 matrix[i][0] = 0;
        }
    }
}
