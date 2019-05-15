//N cars are going to the same destination along a one lane road.  The destination is target miles away. Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road. A car can never pass another car ahead of it,
//but it can catch up to it, and drive bumper to bumper at the same speed. The distance between these two cars is ignored - they are assumed to have the same position. A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also
//a car fleet. If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet. How many car fleets will arrive at the destination?
//Example 1:
//Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//Output: 3
//Explanation:
//The cars starting at 10 and 8 become a fleet, meeting each other at 12.
//The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
//The cars starting at 5 and 3 become a fleet, meeting each other at 6.
//Note that no other cars meet these fleets before the destination, so the answer is 3.

package Medium;
import java.util.*;

public class CarFleet {	
	public int carFleet(int target, int[] position, int[] speed) {  
		// Keeps the data in sorted order
        TreeMap<Integer, Double> m = new TreeMap<>();
        
        // Create a dictionary for remaining distance as key and time as value
        for (int i = 0; i < position.length; ++i) 
            m.put(-position[i], (double)(target - position[i]) / speed[i]);
        int res = 0; double cur = 0;
        
        // If the time required is greater than current time, then increment the counter
        for (double time : m.values())
        {
            if (time > cur) 
            {
                cur = time;
                res++;
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		int target = 12;
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		CarFleet obj = new CarFleet();
		System.out.println(obj.carFleet(target, position, speed));
	}

}
