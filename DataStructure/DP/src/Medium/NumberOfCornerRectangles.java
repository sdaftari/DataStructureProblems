//Example 1:
//Input: grid = 
//[[1, 0, 0, 1, 0],
// [0, 0, 1, 0, 1],
// [0, 0, 0, 1, 0],
// [1, 0, 1, 0, 1]]
//Output: 1
//Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
// Time: // (O(m^2 * n)) 

package Medium;

public class NumberOfCornerRectangles {
	
	public int countCornerRectangles(int[][] grid) 
	{
        int ans = 0;
        // fix upper horizontal line
        for (int i = 0; i < grid.length - 1; i++)
        {
            // fix bottom horizontal line
            for (int j = i + 1; j < grid.length; j++)
            {
                int counter = 0;
                // count how many vertical lines can be found
                for (int k = 0; k < grid[0].length; k++)
                {
                    // for each matched
                    if (grid[i][k] == 1 && grid[j][k] == 1) 
                        counter++;
                }
                
                // If there are multiple vertical lines found, the two of them can be chosen using combination formula (n()n-1)/2
                if (counter > 0) 
                    ans += counter * (counter - 1) / 2;
            }
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
