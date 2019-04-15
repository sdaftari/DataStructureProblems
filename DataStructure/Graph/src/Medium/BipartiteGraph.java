 //graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
//Example 1:
//Input: [[1,3], [0,2], [1,3], [0,2]]
//Output: true
//Explanation: 
//The graph looks like this:
//0----1
//|    |
//|    |
//3----2
//We can divide the vertices into two groups: {0, 2} and {1, 3}.

package Medium;

public class BipartiteGraph {
	
	public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];	
        
        //This graph might be a disconnected graph. So check each unvisited node.
        for (int i = 0; i < n; i++)
        {
        	// If not visited, and color is not valid, return false
            if (colors[i] == 0 && !validColor(graph, colors, 1, i))
                return false;
        }
        
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node)
    {
        // use two colors to color the graph and see if there are any adjacent nodes having the same color.
        // 0: Haven't been colored yet.
        // 1: Blue.
        // -1: Red.
        // For each node,
        
        // If it has been colored, check if the current color is the same as the color that is going to be used to color it.
        if (colors[node] != 0) 
            return colors[node] == color;
        
        // If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
        colors[node] = color;       
        for (int next : graph[node])
        {
        	// Check if next is colored with different color
            if (!validColor(graph, colors, -color, next)) 
                return false;
        }
            
        return true;
    }
    
    // Possible Bipartition
    // group[i] = 0 means node i hasn't been visited.
    // group[i] = 1 means node i has been grouped to 1.
    // group[i] = -1 means node i has been grouped to -1.
    // Each person may dislike some other people, and they should not go into the same group. 
    // Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
    // Return true if and only if it is possible to split everyone into two groups in this way.
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        
        // Create graph for dislikes
        for (int[] d : dislikes) 
        {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        
        int[] group = new int[N];
        for (int i = 0; i < N; i++)
        {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) 
                return false;
        }
            
        return true;
    }
        
    private boolean dfs(int[][] graph, int[] group, int index, int g) 
    {
        group[index] = g;
        for (int i = 0; i < graph.length; i++)
        {
        	// If index and i dislike each other
            if (graph[index][i] == 1)
            {
            	// For index, group[i] which belongs to dislike and has same color, return false
                if (group[i] == g) 
                    return false;
                
                if (group[i] == 0 && !dfs(graph, group, i, -g)) 
                    return false;
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
