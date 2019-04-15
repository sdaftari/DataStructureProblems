// In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  
// If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
// Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  
// More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
//Example:
//Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//Output: [2,4,5,6]

package Medium;
import java.util.*;

public class EventualSafeStates {
	
	public static final int UNKNOWN = 0;  // unknown.
    public static final int UNSAFE = 1;   // unsafe
    public static final int SAFE   = 2;   // safe

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] states = new int[N];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            if(dfs(graph, i, states))
                ans.add(i);
        }
        
        return ans;
    }
    
    private boolean dfs(int[][] graph, int idx, int[] states)
    {
        // already visited, return if the state is safe or not
        if(states[idx] != UNKNOWN)
            return states[idx] == SAFE;
        
        // Initialize with safe state and check if there is a cycle
        states[idx] = UNSAFE;
        for(int node: graph[idx])
        {
            // has cycle
            if(!dfs(graph, node, states))
                return false;
        }
        
        // no cycle, then make that node safe
        states[idx] = SAFE;
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
