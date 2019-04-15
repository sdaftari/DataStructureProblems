//Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0. The given number can be big upto 2^100. 
//It is recommended to finish the task using one traversal of input binary string.
//Example:
//Input:
//2
//011
//100
//
//Output:
//1
//0

package Medium;

public class BinaryStringMultipleOfThree {
	
	// checks if binary characters 
    // are multiple of 3 
    static boolean isMultiple3(char c[], int size) 
    { 
        // initial state is 0th 
        char state = '0'; 
      
        for (int i = 0; i < size; i++) { 
      
            // storing binary digit 
            char digit = c[i]; 
      
            switch (state) { 
      
            // when state is 0 
            case '0': 
                if (digit == '1') 
                    state = '1'; 
                break; 
      
            // when state is 1 
            case '1': 
                if (digit == '0') 
                    state = '2'; 
                else
                    state = '0'; 
                break; 
      
            // when state is 2 
            case '2': 
                if (digit == '0') 
                    state = '1'; 
                break; 
            } 
        } 
      
        // if final state is 0th state 
        if (state == '0') 
            return true; 
        return false; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}