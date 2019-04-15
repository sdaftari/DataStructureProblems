//// Redundant Connect I (Undirected Graph)
//In this problem, a tree is an undirected graph that is connected and has no cycles.
//The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. 
//The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
//The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
//Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
//
//Example 1:
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given undirected graph will be like this:
//  1
// / \
//2 - 3

//Redundant Connection II (Directed Graph)

package Medium;

public class RedundantConnections {
	public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[2001]; 
        for (int i = 0; i < parents.length; i++) 
            parents[i] = i;
        
        for (int[] edge : edges)
        {
            int from = edge[0], to = edge[1];
            if(find(from, parents) == find(to, parents))
                return edge;
            union(from, to, parents);
        }
        
        return null;
    }
    
    private int find(int node, int[] parents) 
    {
        while(node != parents[node]) 
            node = parents[node];
        
        return node;
    }
    
    private void union(int a, int b, int[] parents) 
    {
        int aRoot = find(a, parents);
        int bRoot = find(b, parents);
        if(aRoot == bRoot) 
            return;
        parents[aRoot] = bRoot;
    }
    
    
    // Directed
//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        int[] can1 = {-1, -1};
//        int[] can2 = {-1, -1};
//        int[] parent = new int[edges.length + 1];
//        for (int i = 0; i < edges.length; i++) 
//        {
//            if (parent[edges[i][1]] == 0) 
//                parent[edges[i][1]] = edges[i][0];
//            else 
//            {
//                can2 = new int[] {edges[i][0], edges[i][1]};
//                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
//                edges[i][1] = 0;
//            }
//        }
//        for (int i = 0; i < edges.length; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < edges.length; i++) {
//            if (edges[i][1] == 0) {
//                continue;
//            }
//            int child = edges[i][1], father = edges[i][0];
//            if (root(parent, father) == child) {
//                if (can1[0] == -1) {
//                    return edges[i];
//                }
//                return can1;
//            }
//            parent[child] = father;
//        }
//        return can2;
//    }
//    
//    int root(int[] parent, int i) {
//        while (i != parent[i]) {
//            parent[i] = parent[parent[i]];
//            i = parent[i];
//        }   
//        return i;
//    }

	public static void main(String[] args) {
		int[][] edges = {{1,2}, {1,3}, {2,3}};
		RedundantConnections obj = new RedundantConnections();
		int[] res = obj.findRedundantConnection(edges);
	}

}
