//Example 1:
//
//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2

// Time: O(nlogn)

package Medium;
import java.util.*;

public class MeetingRoom {
	
	public class Interval 
	{
		int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	
	public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) 
        {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) 
        {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
