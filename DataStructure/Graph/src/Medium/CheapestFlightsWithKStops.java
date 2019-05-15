//Example 1:
//Input: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//Output: 200
//Explanation: The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

package Medium;
import java.util.*;

public class CheapestFlightsWithKStops {
	// Similar idea of Dijkstra's algorithm, but we need to keep the path.
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Map with key as source and value as map again with destination as key and prices as values
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights)
        {
            if (!prices.containsKey(f[0])) 
                prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        // price, city, stops
        pq.add(new int[] {0, src, K + 1});
        
        while (!pq.isEmpty())
        {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) 
                return price;
            if (stops > 0)
            {
                // Get the value for that src
                // The value will be a map with keys as destinations from that src and value as price
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet())
                {
                    // add the price for that destination to the original price, change new sorce as a and decrement the #stops
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
