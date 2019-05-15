//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
//Example 1:
//Input: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//Output: 3
//Explanation:
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//Therefore, return 3 as the starting index.

// Time: O(n)

package Medium;

public class GasStation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || gas.length == 0 || cost == null || cost.length == 0) 
            return 0;
        int sum = 0;
        for(int i = 0;i< gas.length;i++)
            sum += gas[i] - cost[i];
        
        if(sum < 0) 
            return -1;
        
        int start = 0;
        for(int i = 0, localSum = 0; i < gas.length; i++)
        {
            localSum += gas[i] - cost[i];   
            //localSum of [start,i] < 0
            if(localSum < 0)
            {
            	//update start
                start = i+1;                            
                localSum = 0;
            }
        }
        return start;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
