//Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//Example:
//Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//Output: true

package Medium;
import java.util.*;

public class GraphValidTree {
	
	public boolean validTree(int n, int[][] edges) {
		// initialize n isolated islands
        int[] nums = new int[n];
        
        // First initialize each node with itself
        for (int i = 0; i < nums.length; i++)
            nums[i] = i;
        
        // perform union find
        for (int i = 0; i < edges.length; i++)
        {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) 
                return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) 
    {
    	// In first call, it won't go inside loop
    	// But after first union, it will try to return to the original parent
    	while (i != nums[i])
        {
            if (nums[i] != i) 
                i = nums[i];
        }
        return i;
    }

	public static void main(String[] args) {
		int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
		GraphValidTree obj = new GraphValidTree();
		System.out.println(obj.validTree(5, edges));
	}

}
