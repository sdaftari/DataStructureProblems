//Given a positive integer n and you can do operations as follow:
//If n is even, replace n with n/2.
//If n is odd, you can replace n with either n + 1 or n - 1.
//What is the minimum number of replacements needed for n to become 1?
//Example 1:
//Input:
//8
//Output:3
//Explanation:
//8 -> 4 -> 2 -> 1

package Medium;
import java.util.*;

public class IntegerReplacement {
	
	public int integerReplacement(int n) 
	{
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long)n);
        return bfs(queue, 0);
    }
    
    private int bfs(Queue<Long> oldqueue, int level) 
    {
        Queue<Long> newqueue = new LinkedList<>();
        while (!oldqueue.isEmpty()) 
        {
            long n = oldqueue.poll();
            if (n == 1) 
                return level;
            
            if (n % 2 == 0) 
                newqueue.offer(n / 2);
            else 
            {
                newqueue.offer(n + 1);
                newqueue.offer(n - 1);
            }
        }
        return bfs(newqueue, level + 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}