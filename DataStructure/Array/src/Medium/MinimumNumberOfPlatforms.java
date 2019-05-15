//Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
//
//Example:
//Input:
//1
//6 
//900  940 950  1100 1500 1800
//910 1200 1120 1130 1900 2000
//
//Output:
//3
//
//Explanation:
//Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
//
//Time Complexity: O(nLogn), assuming that a O(nLogn) sorting algorithm for sorting arr[] and dep[].

package Medium;
import java.util.*;

public class MinimumNumberOfPlatforms {

	// Returns minimum number of platforms required 
	static int findPlatform(int arr[], int dep[], int n) 
	{ 
	   Arrays.sort(arr); 
	   Arrays.sort(dep); 
	   
	   // plat_needed indicates number of platforms needed at a time 
	   int plat_needed = 1, result = 1; 
	   int i = 1, j = 0; 
	   
	   while (i < n && j < n) 
	   { 
	      // If next event in sorted order is arrival, increment count of platforms needed 
	      if (arr[i] <= dep[j]) 
	      { 
	          plat_needed++; 
	          i++; 
	   
	          // Update result if needed  
	          if (plat_needed > result)  
	              result = plat_needed; 
	      } 
	   
	      // Else decrement count of platforms needed 
	      else
	      { 
	          plat_needed--; 
	          j++; 
	      } 
	   } 
	   
	   return result; 
	} 
	
	
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
        for(int i = 0; i < starts.length; i++) 
        {
            if(starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
	
	public static void main(String[] args) {
		int[] arr = {900,  940, 950,  1100, 1500, 1800};
		int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
		System.out.println(findPlatform(arr, dep, 6));
	}

}
