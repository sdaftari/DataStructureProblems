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
//A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. 
//Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
//You may assume all four edges of the grid are all surrounded by water.
//Example:
//Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
//Output: [1,1,2,3]
//Explanation:
//Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

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
    
    // Number of Islands II (Union and Find)  
    public List<Integer> numIslands2(int m, int n, int[][] positions) 
    {
    	List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) 
        	return result;

        // number of islands
        int count = 0;    
        
        // one island = one tree
        int[] roots = new int[m * n];       
        Arrays.fill(roots, -1);            

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int[] p : positions) 
        {
        	// assume new point is isolated island
            int root = n * p[0] + p[1];     
            
            // add new island
            roots[root] = root;             
            count++;

            // Check for the neighbors, if any of them is island, find the original parent and perform union
            for(int[] dir : dirs) 
            {
                int x = p[0] + dir[0]; 
                int y = p[1] + dir[1];
                int nb = n * x + y;
                
                // If there is already water, continue
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) 
                	continue;
                
                // If there is no water, find the original island
                int rootNb = findIsland(roots, nb);
                if(root != rootNb) 
                {         
                	// if neighbor is in another island
                    roots[root] = rootNb;   // union two islands 
                    root = rootNb;          // current tree root = joined tree root
                    count--;               
                }
            }

            result.add(count);
        }
        return result;
    }
    
    public int findIsland(int[] roots, int id) 
    {
        while(id != roots[id]) 
        	id = roots[id];
        return id;
    }


    	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
