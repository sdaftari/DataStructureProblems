//Example:
//Input:
//[[10,16], [2,8], [1,6], [7,12]]
//Output:
//2
//Explanation:
//One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
//
//Time: O(n)

package Medium;
import java.util.*;

public class MinimumBalloonsToBurstBalloons {

	public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        
        // Sort in ascending order of end-co-ordinate
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        // First shoot at the end of first balloon's end point and increment the counter
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        // For rest of the balloons, check if start point is less than previous's hitted balloon's end point
        for (int i = 1; i < points.length; i++)
        {
            if (arrowPos >= points[i][0]) 
                continue;
            
            arrowCnt++;
            arrowPos = points[i][1];
        }
        
        return arrowCnt;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
