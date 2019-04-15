//In Pascal's triangle, each number is the sum of the two numbers directly above it.
//Example:
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]

// Time: O(n^2)

package Easy;
import java.util.*;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> generate(int numRows) 
	{
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numRows; i++)
        {
            List<Integer> list = new ArrayList<>();
            
            for (int j = 0; j < i+1; j++)
            {
                // For the first and last cells, add 1
                if (j == 0 || j == i)
                    list.add(1);
                else
                {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            
            result.add(list);
        }
        
        return result;
    }
	
	// To get the list from specific row
	public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++)
        {
            list = new ArrayList<>();
            
            for (int j = 0; j < i+1; j++)
            {
                // For the first and last cells, add 1
                if (j == 0 || j == i)
                    list.add(1);
                else
                {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            
            result.add(list);
        }
        
        return list;
    }

}
