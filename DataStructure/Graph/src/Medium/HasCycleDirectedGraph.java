package Medium;
import java.util.*;

public class HasCycleDirectedGraph 
{
	public boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited,boolean[] explored) 
    {
        Arrays.fill(visited,false);
        //Arrays.fill(explored,false);
        for(int i=0;i<v;i++)
        {
            if(cycleUtil(i,alist,visited))
                return true;
        }
        return false;
    }
    
    public boolean cycleUtil(int i,LinkedList<Integer>alist[],boolean[] visited) 
    {
        if(visited[i])
            return true;
            
        visited[i]=true;
        Iterator<Integer> it = alist[i].iterator();
        while(it.hasNext())
        {
            int n = it.next();
            if(visited[n])
                return true;
                
            else if(!visited[n] && cycleUtil(n,alist,visited))
                return true;
        }
        visited[i]=false;
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
