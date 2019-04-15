//Search In 2D matrix I (// The first integer of each row is greater than the last integer of the previous row.)
//Example 1:
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// Time: O(n log n)

//Search In 2D Matrix II (Integers in each column are sorted in ascending from top to bottom.)
//Example: 
//
//Consider the following matrix:
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//O(m+n)


package Medium;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// The first integer of each row is greater than the last integer of the previous row.
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int low = 0, high = (matrix.length * matrix[0].length) - 1;
        while (low <= high)
        {
            int mid = (low+high) >> 1; // Same as /2. But faster
            
            // Instead of matrix, consider it This gives
            int[] rowCol = getRowCol(mid, matrix[0].length);
            int midElem = matrix[rowCol[0]][rowCol[1]];
            if( midElem == target)
                return true;
            if (midElem>target)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return false;
    }
    
    private int[] getRowCol(int no, int n)
    {
        return new int[] {no/n, no%n};
    }
    
    
    public boolean searchMatrixII(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) 
            return false;
        
        // Start from last col of first row
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) 
        {
            if(target == matrix[row][col]) 
                return true;
            else if(target < matrix[row][col]) 
                col--;
            else if(target > matrix[row][col]) 
                row++;
        }
        return false;
    }

}
