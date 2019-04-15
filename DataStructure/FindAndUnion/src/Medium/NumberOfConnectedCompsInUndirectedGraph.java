//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
//
//Example 1:
//
//Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//Output: 2

package Medium;

public class NumberOfConnectedCompsInUndirectedGraph {
	
	public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) 
            roots[i] = i; 
        
        for(int[] e : edges)
        {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2)
            {
                roots[root1] = root2;  // union
                n--;
            }
        }
        
        return n;
    }
    
    public int find(int[] roots, int id) 
    {
        while(roots[id] != id) 
        {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
