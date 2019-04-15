//Given an integer an N. The task is to print the position of first set bit found from right side in the binary representation of the number.
//Example:
//Input:
//2
//18
//12
//
//Output:
//2
//3
//Explanation:
//Testcase 1: Binary representation of the 18 is 010010, the first set bit from the right side is at position 2.

package Easy;

public class FirstSetBitFromRight {
	
	static int INT_SIZE = 32; 
	  
    static int Right_most_setbit(int num) 
    { 
        int pos = 1; 
        // counting the position of first set bit 
        for (int i = 0; i < INT_SIZE; i++) 
        { 
            if ((num & (1 << i))== 0) 
                pos++; 
              
            else
                break; 
        } 
        return pos; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
