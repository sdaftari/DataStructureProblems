//Example 3:
//Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//Output: 2
//Explanation: 
//We start with 10 liters of fuel.
//We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
//Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
//We made 2 refueling stops along the way, so we return 2.
// Time: O(NlogN)

package Hard;
import java.util.*;

public class MinimumNumberOfRefuelingStops {
	
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; startFuel < target; res++) 
        {
            while (i < stations.length && stations[i][0] <= startFuel)
                pq.offer(-stations[i++][1]);
            if (pq.isEmpty()) 
                return -1;
            startFuel += -pq.poll();
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
