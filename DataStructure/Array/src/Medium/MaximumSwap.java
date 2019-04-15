//Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
//Example 1:
//Input: 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
// Time: O()

package Medium;

public class MaximumSwap {

	public static void main(String[] args) {
		MaximumSwap obj = new MaximumSwap();
		System.out.println(obj.maximumSwap(2736));
	}

	public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) 
        {
        	// bucket will contain the index in the original array
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) 
        {
        	// iterate over buckets
            for (int k = 9; k > digits[i] - '0'; k--) 
            {
            	// For each position, we check whether there exists a larger digit in this num (start from 9 to current digit so that largest num will be swapped). 
            	// We also need to make sure the position of this larger digit is behind the current one. 
            	// If we find it, simply swap these two digits and return the result.
                if (buckets[k] > i) 
                {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
}
