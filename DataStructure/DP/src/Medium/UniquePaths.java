//A robot is located at the top-left corner of a m x n grid .
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid .
//How many possible unique paths are there?

package Medium;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Without obstacles UniquePaths I
	public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        // Make first col 1
        for(int i = 0; i<m;i++)
            map[i][0] = 1;
        // Make first row 1
        for(int j= 0;j<n;j++)
            map[0][j]=1;
        
        for(int i = 1;i<m;i++)
        {
            for(int j = 1;j<n;j++)
            {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
	
	// With obstacles UniquePaths II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Empty case
        if(obstacleGrid.length == 0) 
            return 0;
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                // For row 0, if there are no paths to left cell, then its 0,else 1
                else if(i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;
                // For col 0, if there are no paths to upper cell, then its 0,else 1
                else if(j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        
        return obstacleGrid[rows - 1][cols - 1];
    }
}
