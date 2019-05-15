package Hard;
import java.util.*;

public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) 
            return 0;
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        // Form histogram
        for(int i = 0;i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '0') 
                    heights[j] = 0;
                else 
                    heights[j]++;
            }  
            ans = Math.max(ans, calcArea(heights));
        }
        return ans;
    }
    
    // Largest area in histogram
    private int calcArea(int[] heights)
    {   
    	//method of problem 84
        if(heights == null || heights.length == 0) 
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i <= heights.length; i++)
        {
        	// If current height is shorter than stack top
            while(stack.peek()!=-1 && (i == heights.length || heights[i] <  heights[stack.peek()]))
            {
            	// Index points to previous higher height
                int index = stack.pop();
                int start = stack.peek() + 1;
                ans = Math.max(ans, heights[index]*(i-start));
            }
            // Add each index onto the stack
            stack.push(i);
        }
        return ans;
    }

	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
		MaximalRectangle obj = new MaximalRectangle();
		System.out.println(obj.maximalRectangle(matrix));
	}

}
