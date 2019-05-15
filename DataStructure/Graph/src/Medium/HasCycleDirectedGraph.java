package Medium;
import java.util.*;

public class HasCycleDirectedGraph 
{
	static class Graph 
	{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) 
        {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) 
            {
                adjList[i] = new LinkedList<>();
            }
        }
        
        public void addEgde(int source, int destination) 
        {
            adjList[source].addFirst(destination);
        }
        
        public boolean isCycle() 
        {
            boolean visited[] = new boolean[vertices];
            boolean recursiveArr[] = new boolean[vertices];

            //do DFS from each node                                                                                                    
            for (int i = 0; i < vertices; i++) 
            {
                if (isCycleUtil(i, visited, recursiveArr))
                    return true;
            }                                        
            return false;
        }

        public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveArr) 
        {
            visited[vertex] = true;
            // set flag true for a parent
            recursiveArr[vertex] = true;

            //recursive call to all the adjacent vertices
            for (int i = 0; i < adjList[vertex].size(); i++) 
            {                
                int adjVertex = adjList[vertex].get(i);
                //if not already visited
                if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)) 
                    return true;
                // If already visited, and recursiveArr[adjVertex], i.e. parent is visited again
                else if (recursiveArr[adjVertex])
                    return true;
            }
            //if reached here means cycle has not found in DFS from this vertex
            //reset
            recursiveArr[vertex] = false;
            return false;
        }
    }
	
    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(1, 2);
        graph.addEgde(2, 3);
        graph.addEgde(3, 1);
        boolean result = graph.isCycle();
        System.out.println("is Cycle present: " + result);
    }
}
