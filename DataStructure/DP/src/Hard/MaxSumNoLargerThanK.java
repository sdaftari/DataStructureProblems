//Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
//Example:
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2 
//Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
//
//Time: O(n^3)

package Hard;
import java.util.*;

public class MaxSumNoLargerThanK {
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] areas = new int[rows][cols]; 
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                int area = matrix[r][c];
                if (r-1 >= 0)
                    area += areas[r-1][c];
                if (c-1 >= 0)
                    area += areas[r][c-1];
                if (r-1 >= 0 && c-1 >= 0)
                    area -= areas[r-1][c-1];
                areas[r][c] = area;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(0);    // padding
                for (int c = 0; c < cols; c++) {
                    int area = areas[r2][c];
                    if (r1-1 >= 0)
                        area -= areas[r1-1][c];
                    Integer ceiling = tree.ceiling(area - k);
                    if (ceiling != null)
                        max = Math.max(max, area - ceiling);
                    tree.add(area);
                }
            }
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
