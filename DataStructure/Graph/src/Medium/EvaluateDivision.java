//Example:
//Given a / b = 2.0, b / c = 3.0. 
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
//return [6.0, 0.5, -1.0, 1.0, -1.0 ].

package Medium;
import java.util.*;

public class EvaluateDivision {
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++)
        {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0]))
            {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            
            if (!pairs.containsKey(equation[1])) 
            {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) 
            	result[i] = -1.0;
        }
        
        return result;
    }
    
    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value)
    {
    	// This avoids getting into a cycle. If we encounter same node3, then there is a cycle and we can not reach the destination node 
        if (set.contains(start)) 
            return 0.0;
        
        // If start is not there, return 0
        if (!pairs.containsKey(start)) 
            return 0.0;
        
        // Completed the query so return the result
        if (start.equals(end)) 
            return value;
        
        set.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        
        for (int i = 0; i < strList.size(); i++) 
        {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) 
                break;
        }
        
        // Suppose we have a path a->b->c, and we have another path a->b->d. If c and d is completely the same, when we found the path a->b->c, 
        // we need to undo the visited node so that we can find the other path a->b->d. Usually in DFS we only visited a node once but here we need to revisit a node in different paths.
        set.remove(start);
        return tmp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
