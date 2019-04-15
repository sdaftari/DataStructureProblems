package Extra;
import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	DepthFirstSearch(int v)
	{
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	void DFS(int v)
	{
		boolean visited[] = new boolean[V];
		
		DFSUtil(visited, v);
	}
	
	void DFSUtil(boolean visited[], int v)
	{		
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> iter = adj[v].listIterator();
		while (iter.hasNext())
		{
			int n = iter.next();
			if (!visited[n])
				DFSUtil(visited, n);
		}
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}

	public static void main(String[] args) {
		DepthFirstSearch g = new DepthFirstSearch(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
	}
}
