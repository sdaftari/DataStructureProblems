//In a given grid, each cell can have one of three values:
//
//the value 0 representing an empty cell;
//the value 1 representing a fresh orange;
//the value 2 representing a rotten orange.
//Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
//Example 1:
//Input: [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//Input: [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.


package Easy;
import java.util.*;

public class RottenOranges {
	
	public int orangesRotting(int[][] grid) {
        if(grid.length == 0) 
        	return 0;
        List<int[]> rotted = new ArrayList<>();
        int fresh = 0;
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
            	// Keep track of rotten oranges
                if(grid[i][j] == 2) 
                	rotted.add(new int[]{i,j});
                
                // Count fresh oranges
                if(grid[i][j] == 1) 
                	fresh++;
            }
        }
        if(fresh == 0) 
        	return 0;
        
        while(rotted.size() > 0)
        {
            List<int[]> temp = new ArrayList<>();
            for(int[] coor : rotted)
            {
            	// For the 4-directionally connected positions, make it rot
                int i = coor[0], j = coor[1];
                if(i-1 >= 0 && grid[i-1][j] == 1)
                {
                    temp.add(new int[]{i-1,j});
                    grid[i-1][j] = 2;
                    fresh--;
                }
                if(i+1 < grid.length && grid[i+1][j] == 1)
                {
                    temp.add(new int[]{i+1,j});
                    grid[i+1][j] = 2;
                    fresh--;
                }
                if(j-1 >= 0 && grid[i][j-1] == 1)
                {
                    temp.add(new int[]{i,j-1});
                    grid[i][j-1] = 2;
                    fresh--;
                }
                if(j+1 < grid[0].length && grid[i][j+1] == 1)
                {
                    temp.add(new int[]{i,j+1});
                    grid[i][j+1] = 2;
                    fresh--;
                }
            }
            rotted = temp;
            ans++;
        }
        if(fresh > 0) 
        	return -1;
        return --ans;
    }

	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		RottenOranges obj = new RottenOranges();
		System.out.println(obj.orangesRotting(grid));
	}

}
