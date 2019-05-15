// Time: O(n)

package Hard;
import java.util.*;

public class Pattern132 {

	class Pair
    {
        int min, max;
        public Pair(int min, int max)
        {
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int n : nums)
        {
            // If new number is less than curr min, add pair (n, n)
            if (stack.isEmpty() || (n < stack.peek().min))
                stack.push(new Pair(n, n));
            else if (n > stack.peek().min)
            {
                // If n is < max, we found 132 pattern
                if (n < stack.peek().max)
                    return true;
                // Else if the number is greater than max
                else
                {
                    Pair curr = stack.pop();
                    curr.max = n;
                    
                    // Here we have found the 13 part. And we have to find 2 part, the smaller number than max
                    // So we will remove all pairs whose max < n since we have to find a smaller number than n now.
                    while (!stack.isEmpty() && n >= stack.peek().max)    
                        stack.pop();
                    // If the next number is smaller than peek().min, it wont come here and new entry is added on stack
                    // So if we get a smaller number than max, it will be definitely greater than peek().min so return true
                    if (!stack.isEmpty() && stack.peek().min < n)   
                        return true;
                    stack.push(curr);
                }
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 2};
		Pattern132 obj = new Pattern132();
		System.out.println(obj.find132pattern(nums));
	}

}
