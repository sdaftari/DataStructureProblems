//A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top

package Easy;
import java.util.*;

public class CountHops {

	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    System.out.println(printCountRec(n));
		}
	}
	
	// Function returns count of ways to cover 'dist' 
    static int printCountRec(int dist) 
    { 
        // Base cases 
        if (dist<0)     
            return 0; 
        if (dist==0)     
            return 1; 
   
        // Recur for all previous 3 and add the results 
        return printCountRec(dist-1) + printCountRec(dist-2) + printCountRec(dist-3); 
    } 

}
