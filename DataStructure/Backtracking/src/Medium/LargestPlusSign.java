//Examples of Axis-Aligned Plus Signs of Order k:
//Order 1:
//000
//010
//000
//
//Order 2:
//00000
//00100
//01110
//00100
//00000
//
//Order 3:
//0000000
//0001000
//0001000
//0111110
//0001000
//0001000
//0000000

package Medium;
import java.util.*;

public class LargestPlusSign {
	
	public int orderOfLargestPlusSign(int N, int[][] mines) 
	{
        int[][] grid = new int[N][N];
        
        for (int i = 0; i < N; i++) 
            Arrays.fill(grid[i], N);

        for (int[] m : mines) 
            grid[m[0]][m[1]] = 0;

        for (int i = 0; i < N; i++) 
        {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
                res = Math.max(res, grid[i][j]);
        }

        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
