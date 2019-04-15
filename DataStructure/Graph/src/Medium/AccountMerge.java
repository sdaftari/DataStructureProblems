package Medium;
import java.util.*;

public class AccountMerge {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //<email node, neighbor nodes>: <john00@mail.com, <johnsmith@mail.com, john00new@mail.com>> or <johnsmith@mail.com, <john00@mail.com, john_newyork@mail.com>>
        Map<String, Set<String>> graph = new HashMap<>();          
        //<email, name> : <johnsmith@mail.com, john>
        Map<String, String> name = new HashMap<>();        
        
        // Build the graph;
        for (List<String> account : accounts)
        {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++)
            {
                if (!graph.containsKey(account.get(i)))
                    graph.put(account.get(i), new HashSet<>());
                
                // Put email as key and name as value
                // This map will have unique emails
                name.put(account.get(i), userName);
                
                // If its first email. continue
                if (i == 1) 
                    continue;
                // Otherwise add adjacent email in each other values
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph; name contains each unique email as key and their corressponding name as value
        for (String email : name.keySet())
        {
            List<String> list = new LinkedList<>();
            if (visited.add(email))
            {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        
        return res;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list)
    {
        list.add(email);
        // For each unique email, get the connected emails
        for (String next : graph.get(email))
        {
            if (visited.add(next)) 
                dfs(graph, next, visited, list);
        }
    }
	
	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<List<String>>();
		List<String> l1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com", "john00new@mail.com");
		List<String> l2 = Arrays.asList("John", "johnnybravo@mail.com");
		List<String> l3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
		List<String> l4 = Arrays.asList("Mary", "mary@mail.com");
		accounts.add(l1);
		accounts.add(l2);
		accounts.add(l3);
		accounts.add(l4);
		
		AccountMerge obj = new AccountMerge();
		List<List<String>> ans = obj.accountsMerge(accounts);
	}

}
