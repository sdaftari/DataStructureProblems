//In given range, print all numbers having unique digits. e.g. In range 1 to 20 should print all numbers except 11.
//Example:
//Input:
//1
//10 20
//Output:
//10 12 13 14 15 16 17 18 19 20

package Medium;

public class UniqueNumbers {

	 // Method to print unique digit numbers 
    // in range from l to r. 
    static void printUnique(int l, int r) 
    { 
        // Start traversing the numbers 
        for (int i=l ; i<=r ; i++) 
        { 
            int num = i; 
            boolean visited[] = new boolean[10]; 
       
            // Find digits and maintain its hash 
            while (num != 0) 
            { 
                // if a digit occcurs more than 1 time then break 
                if (visited[num % 10]) 
                    break; 
       
                visited[num%10] = true; 
       
                num = num/10; 
            } 
       
            // num will be 0 only when above loop 
            // doesn't get break that means the 
            // number is unique so print it. 
            if (num == 0) 
                System.out.print(i + " "); 
        } 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
