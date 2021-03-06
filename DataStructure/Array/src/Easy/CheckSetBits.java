//Given a number N. Write a program to check whether every bit in the binary representation of the given number is set or not.
//Time: O(d), where d is #bits

package Easy;

public class CheckSetBits {
	
	// function to check if all the bits 
    // are setthe bits are set or not 
    // in the binary representation of 'n' 
    static String areAllBitsSet(int n) 
    { 
        // all bits are not set 
        if (n == 0) 
            return "No"; 
      
        // loop till n becomes '0' 
        while (n > 0) 
        { 
            // if the last bit is not set 
            if ((n & 1) == 0) 
                return "No"; 
      
            // right shift 'n' by 1 
            n = n >> 1; 
        } 
      
            // all bits are set 
            return "Yes"; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
