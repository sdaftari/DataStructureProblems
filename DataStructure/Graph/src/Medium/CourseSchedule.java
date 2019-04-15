//Example 1:
//Input: 2, [[1,0]] 
//Output: true
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

package Medium;
import java.util.*;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) 
            graph[i] = new ArrayList<>();
        
        // If we have prereq 0 for course 1, [[1,0]] then (0 -> 1)
        for (int[] pair : prerequisites)
        {
        	//graph[0] = 1
        	// indegree[1] = 1 (because of course 0)
            indegree[pair[0]]++;
            graph[pair[1]].add(pair[0]);
        }
        
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++)
        {
        	// Add courses with no pre reqs
            if (indegree[i] == 0)
                toVisit.offer(i);
        }
        
        int count = 0;
        while(!toVisit.isEmpty())
        {
        	//  Poll each course with no prereqs
            int from = toVisit.poll();            
            for (int to : graph[from])
            {
            	// for each course dependent on prereq, decrement the degree
                indegree[to]--;
                if (indegree[to] == 0) 
                    // If the course has only prereq as form, and no more prereqs remianing, add it to queue
                    toVisit.offer(to);
            }
            
            count++;
        }
        
        if(count == numCourses)
            return true;
        else    
            return false;
    }
	
	// Finds order of course schedule CourseSchedule II
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) 
        {
            graph[i] = new ArrayList<>();
        }
        
        // In this case increment the degree of courses having prereqs
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            // Add the course in prereqs
            graph[pair[1]].add(pair[0]);
        }
        
        Queue<Integer> toVisit = new ArrayDeque<>();
        
        // base course who doesn't have prerequisites
        for (int i = 0; i < inDegree.length; i++) 
        {
            if (inDegree[i] == 0) 
                toVisit.offer(i);
        }
        
        int[] order = new int[numCourses];
        int visited = 0;
        while (!toVisit.isEmpty())
        {
            int from = toVisit.poll();
            // Add the course from queue having no prereqs
            order[visited++] = from;
            for (int to : graph[from])
            {
                inDegree[to]--;
                if (inDegree[to] == 0) 
                    // If the course has only prereq as form, and no more prereqs remianing, add it to queue
                    toVisit.offer(to);
                else if (inDegree[to] < 0) 
                    return new int[0];
            }
        }
        
        return visited == numCourses ? order : new int[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
