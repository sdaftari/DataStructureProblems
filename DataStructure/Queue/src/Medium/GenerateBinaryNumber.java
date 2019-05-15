//Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
//Examples:
//Input: n = 2
//Output: 1, 10
//Input: n = 5
//Output: 1, 10, 11, 100, 101

package Medium;
import java.util.*;

public class GenerateBinaryNumber {

	public static void main(String[] args) {
		int m=0;
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        
        while (m-- > 0)
        {
            int n = sc.nextInt();
    		// Create an empty queue of strings 
            Queue<String> q = new LinkedList<String>(); 
              
            // Enqueue the first binary number 
            q.add("1"); 
              
            // This loops is like BFS of a tree with 1 as root 
            // 0 as left child and 1 as right child and so on 
            while(n-- > 0) 
            { 
                // print the front of queue 
                String s1 = q.peek(); 
                q.remove(); 
                System.out.print(s1 + " "); 
                  
                // Store s1 before changing it 
                String s2 = s1; 
                  
                // Append "0" to s1 and enqueue it 
                q.add(s1 + "0"); 
                  
                // Append "1" to s2 and enqueue it. Note that s2 contains 
                // the previous front 
                q.add(s2 + "1"); 
            } 
            
            System.out.println();
        }
	}

}
