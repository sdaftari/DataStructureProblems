//Example 1:
//
//Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

package Medium;
import java.util.*;

public class ReconstructIternary {
	Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        // Add all source and destinations in map
        for (String[] ticket : tickets)
        {
            // One source, multiple destinations
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("JFK");
        return path;
    }
    
    public void dfs(String departure)
    {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
