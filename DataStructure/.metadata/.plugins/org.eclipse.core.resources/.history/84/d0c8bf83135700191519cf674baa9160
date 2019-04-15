//Example 1:
//Input: [[1, 2], [2, 3], [6, 1]]
//Output: [2, 5, 5]
//Explanation:
//After the first drop of positions[0] = [1, 2]:
//_aa
//_aa
//-------
//The maximum height of any square is 2.
//After the second drop of positions[1] = [2, 3]:
//__aaa
//__aaa
//__aaa
//_aa__
//_aa__
//--------------
//The maximum height of any square is 5.  
//The larger square stays on top of the smaller square despite where its center
//of gravity is, because squares are infinitely sticky on their bottom edge.
//After the third drop of positions[1] = [6, 1]:
//__aaa
//__aaa
//__aaa
//_aa
//_aa___a
//--------------
//The maximum height of any square is still 5.
//Thus, we return an answer of [2, 5, 5].
// Time: O(n^2)

package Hard;
import java.util.*;

public class FallingSquares {
	
	private class Interval 
    {
        int start, end, height;
        public Interval(int start, int end, int height) 
        {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }
    
    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int h = 0;
        for (int[] pos : positions) 
        {
            Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
            h = Math.max(h, getHeight(intervals, cur));
            res.add(h);
        }
        return res;
    }
    
    private int getHeight(List<Interval> intervals, Interval cur) 
    {
        int preMaxHeight = 0;
        for (Interval i : intervals) {
            // Interval i does not intersect with cur
            if (i.end < cur.start) 
                continue;
            if (i.start > cur.end) 
                continue;
            // find the max height beneath cur
            preMaxHeight = Math.max(preMaxHeight, i.height);
        }
        cur.height += preMaxHeight;
        intervals.add(cur);
        return cur.height;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
