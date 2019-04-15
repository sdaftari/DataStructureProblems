//In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
//(Note that backslash characters are escaped, so a \ is represented as "\\".)
//Return the number of regions.
//Example 1:
//Input:
//[
//  " /",
//  "/ "
//]
//Output: 2 (Diagonal)


package Medium;

public class RegionsCutBySlashes {
	int count, n;
    int[] f;
    
    public int regionsBySlashes(String[] grid) 
    {
        n = grid.length;
        f = new int[n * n * 4];
        count = n * n * 4;
        // First assume each as separate cell so make f(x) = x
        for (int i = 0; i < n * n * 4; ++i)
            f[i] = i;
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                // If we number 4 cells as 0 for top, 1 for right, 2 for bottom, 3 for left
                // whatever / or \ comes, 2 of upper cell will always merge with 0 of cell below it
                // SImilarly, 3 will always merge with 1 of left cell
                if (i > 0) 
                    union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) 
                    union(g(i , j - 1, 1), g(i , j, 3));
                if (grid[i].charAt(j) != '/')
                {
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }
                if (grid[i].charAt(j) != '\\')
                {
                    union(g(i , j, 0), g(i , j,  3));
                    union(g(i , j, 2), g(i , j,  1));
                }
            }
        }
        
        return count;
    }
    
    public int find(int x) 
    {
        // if x != f(x), that part of cell is already merged. So find the parent
        if (x != f[x]) 
            f[x] = find(f[x]);
        
        return f[x];
    }
    
    //Merges two parts 
    public void union(int x, int y) 
    {
        x = find(x); 
        y = find(y);
        if (x != y) 
        {
            f[x] = y;
            // Decrement the count
            count--;
        }
    }
    
    // Gives the part of grid cell of i, j index in n*n grid and kth part (of 0, 1, 2, 3)
    public int g(int i, int j, int k) 
    {
        return (i * n + j) * 4 + k;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
