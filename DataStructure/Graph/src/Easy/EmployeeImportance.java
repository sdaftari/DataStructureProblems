//Example 1:
//
//Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//Output: 11
//Explanation:
//Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.

// Time: O(n). Space: O(n)

package Easy;
import java.util.*;

public class EmployeeImportance {
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
	public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) 
            map.put(employee.id, employee);
        
        Queue<Employee> queue = new LinkedList<>();
        // In case of full size, offer just return false but add will throw an exception
        queue.offer(map.get(id));
        
        while (!queue.isEmpty()) 
        {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) 
                queue.offer(map.get(subordinate));
        }
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
