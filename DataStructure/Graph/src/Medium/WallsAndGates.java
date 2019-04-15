//You are given a m x n 2D grid initialized with these three possible values.
//-1 - A wall or an obstacle.
//0 - A gate.
//INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
//Example: 
//Given the 2D grid:
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
//After running your function, the 2D grid should be:
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4

package Medium;
import java.util.*;

public class WallsAndGates {
	
	public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) 
            return;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        // Add all gates to queue
        for (int i = 0; i < rooms.length; i++) 
        {
            for (int j = 0; j < rooms[0].length; j++) 
            {
                if (rooms[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
        
        while (!queue.isEmpty()) 
        {
            //level traversal, make sure get the shortest distance
            int size = queue.size();
            for(int s = 0; s < size; s++)
            {
                int[] top = queue.poll();
                // Retrieve the gate co-ordinate
                int row = top[0], col = top[1];
                for(int[] dir : directions)
                {
                    int newX = row + dir[0], newY = col + dir[1];
                    if(newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms[0].length)
                        continue;
                    if(rooms[newX][newY] == Integer.MAX_VALUE)
                    {
                        rooms[newX][newY] = rooms[row][col] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
