package Extra;
import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	BreadthFirstSearch(int v)
	{
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	void BFS(int s)
	{
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0)
		{
			s = queue.poll();
			System.out.println(s + " ");
			Iterator<Integer> iter = adj[s].listIterator();
			while (iter.hasNext())
			{
				int n = iter.next();
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch g = new BreadthFirstSearch(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.BFS(2);
	}
}
