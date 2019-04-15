// Number of Islands I 
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.
//Example:
//Input:
//11000
//11000
//00100
//00011
//Output: 3

// Number of islands II

package Medium;
import java.util.*;

public class NumberOfIslands {
	
	private int n;
    private int m;
	public int numIslands(char[][] grid) 
	{
        int count = 0;
        n = grid.length;
        if (n == 0) 
        	return 0;
        m = grid[0].length; 
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == '1')
                {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j)
    {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') 
            return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
    
    // Number of Islands II    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	  List<Integer> res = new LinkedList<>();
    	  if (m <= 0 || n <= 0) { return res; }

    	  int count = 0;
    	  int[] roots = new int[m * n];   // 1D array of roots
    	  int[] size  = new int[m * n];   // 1D array of size of each tree
    	  Arrays.fill(roots, -1);         // Every position is water initially.
    	  int[][] directions = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    	  for (int[] p : positions) 
    	  {
    	    int island = p[0] * n + p[1];
    	    roots[island] = island;     // Set it to be the root of itself.
    	    size[island]++;
    	    count++;

    	    // Check four directions
    	    for (int[] dir : directions) 
    	    {
    	      int x = p[0] + dir[0], y = p[1] + dir[1];
    	      int neighbor = x * n + y;
    	      // Skip when x or y is invalid, or neighbor is water.
    	      if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbor] == -1) 
    	    	  continue; 
    	      int neighborRoot = find(neighbor, roots);
    	      int islandRoot   = find(island, roots);
    	      if (islandRoot != neighborRoot) {
    	        // Union by size
    	        if (size[islandRoot] >= size[neighborRoot]) 
    	        {
    	          size[islandRoot] += size[neighborRoot];
    	          roots[neighborRoot] = islandRoot;
    	        } 
    	        else 
    	        {
    	          size[neighborRoot] += size[islandRoot];
    	          roots[islandRoot] = neighborRoot;
    	        }
    	        count--;
    	      }
    	    }

    	    res.add(count);
    	  }

    	  return res;
    	}

    	private int find(int id, int[] roots) {
    	  if (roots[id] == id) { return id; }
    	  else {
    	    roots[id] = find(roots[id], roots);    // path compression
    	    return roots[id];
    	  }
    	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
