//You are given an integer n. You need to convert all zeroes of n to 5.
//Example:
//Input
//2
//1004
//121
//Ouput
//1554
//121

package Easy;

public class Replace0With5 {
	
	static int convert0To5Rec(int num) 
    { 
        // Base case 
        if (num == 0) 
            return 0; 
          
        // Extraxt the last digit and change it if needed 
        int digit = num % 10;  
        if (digit == 0) 
            digit = 5; 
  
        // Convert remaining digits and append the  
        // last digit 
        return convert0To5Rec(num / 10) * 10 + digit; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
