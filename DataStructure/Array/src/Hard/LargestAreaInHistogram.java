//Do push all heights including 0 height.
//i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >= height[tp], because the index on top of the stack right now is the first index left of tp with height smaller than tp's height.

// Time: O(n)

package Hard;
import java.util.*;

public class LargestAreaInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestRectangleArea(int[] heights) {
        int len  = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++)
        {
            int h = (i == len ? 0 : heights[i]);
            
            if(stack.isEmpty() || h >= heights[stack.peek()])
                stack.push(i);
            else
            {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] *  (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }  
        }
        
        return maxArea;
    }
	
	// To find the max rectangle with 1
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) 
            return 0;
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        // Form histogram
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '0') 
                    heights[j] = 0;
                else 
                    heights[j]++;
            }  
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
}
