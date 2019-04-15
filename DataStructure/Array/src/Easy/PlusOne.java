//Example 1:
//
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.

// Time: O(n)

package Easy;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = new int[] {4,3,2,1};
		PlusOne obj = new PlusOne();
		int[] res = obj.plusOne(digits);
		for (int i : res)
			System.out.print(i + " ");
	}

	public int[] plusOne(int[] digits) 
	{
        int n = digits.length;
        for (int i = n-1; i >= 0; i--)
        {
        	// If last digit is less than 9, add 1 and return
            if (digits[i] < 9)
            {
                digits[i]++;    
                return digits;
            }
            
            // Otherwise make that digit 0 and decrement i
            digits[i] = 0;
        }
        
        // If all the digits are becoming 0, add 1 at the start
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
