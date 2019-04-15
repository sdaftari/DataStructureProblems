//Example 1:
//[0,1,3,5,6,8,12,17]
//There are a total of 8 stones.
//The first stone at the 0th unit, second stone at the 1st unit,
//third stone at the 3rd unit, and so on...
//The last stone at the 17th unit.
//
//Return true. The frog can jump to the last stone by jumping 
//1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
//2 units to the 4th stone, then 3 units to the 6th stone, 
//4 units to the 7th stone, and 5 units to the 8th stone.

package Hard;
import java.util.*;

public class FrogJump {
	
	public boolean canCross(int[] stones) 
	{
        if (stones.length == 0) {
        	return true;
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
        	map.put(stones[i], new HashSet<Integer>() );
        }
        
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : map.get(stone)) {
        		int reach = step + stone;
        		if (reach == stones[stones.length - 1]) {
        			return true;
        		}
        		HashSet<Integer> set = map.get(reach);
        		if (set != null) {
        		    set.add(step);
        		    if (step - 1 > 0) set.add(step - 1);
        		    set.add(step + 1);
        		}
        	}
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
