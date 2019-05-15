//On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
//
//Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
//
//You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
//
//Example 1:
//
//Input: [[0,2],[1,3]]
//Output: 3
//Explanation:
//At time 0, you are in grid location (0, 0).
//You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
//
//You cannot reach point (1, 1) until time 3.
//When the depth of water is 3, we can swim anywhere inside the grid.

package Medium;
import java.util.*;

public class SwimInRisingWater {

	public int swimInWater(int[][] grid) 
	{
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(N*N-1)) 
        {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }
	
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) 
    {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i*grid.length+j)) 
        	return;
        visited.add(i*grid.length+j);
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1], time, visited);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
