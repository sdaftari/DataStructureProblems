//On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
//Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
//What is the largest possible number of moves we can make?
//Example 1:
//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5

package Medium;
import java.util.*;

public class MostStonesRemovedWithSameRowCol {

	Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;
    public int removeStones(int[][] stones) 
    {        
        for (int i = 0; i < stones.length; i++)
            // a row index, connect two stones on this row
            // a col index, connect two stones on this col.
            // We need to uniquely identify row index and col index
            // So negate col index so that 0th row will have different value from 0th col
            // Ex, (0, 0) will be represented as (0, 15) in 4 bit 
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }
    
    public int find(int x)
    {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }
    
    public void union(int x, int y) 
    {
        x = find(x);
        y = find(y);
        if (x != y) 
        {
            f.put(x, y);
            islands--;
        }
    }
	
	public static void main(String[] args) {
		int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		MostStonesRemovedWithSameRowCol obj = new MostStonesRemovedWithSameRowCol();
		System.out.println(obj.removeStones(stones));
	}

}
