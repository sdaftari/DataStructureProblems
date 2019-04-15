package Medium;
import java.util.*;

public class CarFleet {	
	public int carFleet(int target, int[] position, int[] speed) {
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
