//Example 1:
//Input:
//n = 2
//logs = 
//["0:start:0",
// "1:start:2",
// "1:end:5",
// "0:end:6"]
//Output:[3, 4]
//Explanation:
//Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1. 
//Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
//Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time. 
//So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
// Time: O(N) and Space: O(N)

package Hard;
import java.util.*;

public class ExclusiveTime {

	public static void main(String[] args) {
		int n = 2;
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		ExclusiveTime obj = new ExclusiveTime();
		System.out.println(obj.exclusiveTime(n, logs));
	}
	
	public int[] exclusiveTime(int n, List<String> logs) 
	{
        int[] res = new int[n];
        int prevTime = 0;
        // Stack keeps the index of log, 0th object
        Stack<Integer> stack = new Stack<>();
        for (String log : logs)
        {
            String[] currLog = log.split(":");
            if (!stack.isEmpty())
            	// res contains the total time spent on stack top's log
                res[stack.peek()] += Integer.parseInt(currLog[2]) - prevTime;
            
            // save the time for next iteration
            prevTime = Integer.parseInt(currLog[2]);
            
            // If its a start, add index on top of the stack
            if (currLog[1].equals("start"))
                stack.push(Integer.parseInt(currLog[0]));
            // else increment 1 time for previous element of stack top
            // also increment prevTime by 1
            else
            {
                res[stack.pop()]++;
                prevTime++;
            }                             
        }
        
        return res;
    }

}
