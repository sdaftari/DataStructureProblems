//Example
//Given input matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]

// Time: O(N^2). Space: In-place

package Medium;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {        
        // Transpose
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = i; j < matrix[0].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Flip symmetrically for each row
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
