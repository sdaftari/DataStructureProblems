package Easy;

public class Atoi {
	
	// A simple atoi() function 
    static int myAtoi(String str) 
    { 
          
        // Initialize result 
        int res = 0;  
          
        // Initialize sign as positive 
        int sign = 1;  
          
        // Initialize index of first digit 
        int i = 0;  
      
        // If number is negative, then  
        // update sign 
        if (str.charAt(0) == '-') 
        { 
            sign = -1;  
              
            // Also update index of first 
            // digit 
            i++;  
        } 
      
        // Iterate through all digits  
        // and update the result 
        for ( ; i < str.length(); ++i) 
            res = res * 10 + str.charAt(0) - '0'; 
      
        // Return result with sign 
        return sign * res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
