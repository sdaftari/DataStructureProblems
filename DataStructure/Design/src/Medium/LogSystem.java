//Example 1:
//put(1, "2017:01:01:23:59:59");
//put(2, "2017:01:01:22:59:59");
//put(3, "2016:01:01:00:00:00");
//retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
//retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.

package Medium;
import java.util.*;

public class LogSystem {

	List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4,7,10,13,16,19};
    
    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        timestamps.add(new String[]{Integer.toString(id), timestamp});
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for (String[] timestamp : timestamps)
            if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
               	timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0)
                res.add(Integer.parseInt(timestamp[0]));
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
