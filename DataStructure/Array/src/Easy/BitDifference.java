//Given two numbers ‘a’ and b’. Write a program to count number of bits needed to be flipped to convert ‘a’ to ‘b’.

package Easy;

public class BitDifference {
	
	// Function that count set bits 
    public static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n != 0) 
        { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
  
    // Function that return count of 
    // flipped number 
    public static int FlippedCount(int a, int b) 
    { 
        // Return count of set bits in 
        // a XOR b 
        return countSetBits(a ^ b); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
