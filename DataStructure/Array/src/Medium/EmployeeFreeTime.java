//Example 1:
//Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//Output: [[3,4]]
//Explanation:
//There are a total of three employees, and all common
//free time intervals would be [-inf, 1], [3, 4], [10, inf].
//We discard any intervals that contain inf as they aren't finite.

package Medium;
import java.util.*;

public class EmployeeFreeTime {
	
	public class Interval 
	{
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
    }
	
	public List<Interval> employeeFreeTime(List<List<Interval>> avails) 
	{
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        avails.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));

        Interval temp = timeLine.get(0);
        for(Interval each : timeLine) 
        {
            if(temp.end < each.start) 
            {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            }
            else
                temp = temp.end < each.end ? each : temp;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
