//Example 1:
//
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]

package Medium;
import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> ans = obj.spiralOrder(matrix);
		// To get the Kth element
		int i = 0, k = 4;
		System.out.println(ans.get(k-1));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0)
            return ans;        
        
        int rowStart = 0; 
        int rowEnd = matrix.length-1;
        int colStart = 0; 
        int colEnd = matrix[0].length-1;
        
        while (rowStart <= rowEnd && colStart <= colEnd)
        {
            int j;
            for (j = colStart; j <= colEnd; j++)
                ans.add(matrix[rowStart][j]);
            rowStart++;
            
            for (j = rowStart; j <= rowEnd; j++)
                ans.add(matrix[j][colEnd]);
            colEnd--;
            
            if (rowStart <= rowEnd)
            {
                for (j = colEnd; j >= colStart; j--)
                    ans.add(matrix[rowEnd][j]);
            }            
            rowEnd--;
            
            if (colStart <= colEnd)
            {
                for (j = rowEnd; j >= rowStart; j--)
                    ans.add(matrix[j][colStart]);
            }
            colStart++;            
        }
        
        return ans;
	}
}
