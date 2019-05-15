//Example:
//
//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

package Medium;
import java.util.*;

public class PacificAtlanticWaterFlow {
	
	int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) 
    {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int n = matrix.length, m = matrix[0].length;
        
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        
        //Vertical border
        for(int i=0; i<n; i++)
        { 
        	// Pacific will flow to first column
            pQueue.offer(new int[]{i, 0});
            // Atlantic will flow to last column
            aQueue.offer(new int[]{i, m-1});
            
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        
        //Horizontal border
        for(int i=0; i<m; i++)
        { 
        	// Pacific will flow to first row
            pQueue.offer(new int[]{0, i});
            
            // Atlantic will flow to last row
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited)
    {
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty())
        {
            int[] cur = queue.poll();
            for(int[] d : dir)
            {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                // Since we need to find the points from which water will flow to both atlantic and pacific, 
                // these points should be taller than the neighbors
                // So if the new points are smaller, continue
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]])
                    continue;
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
