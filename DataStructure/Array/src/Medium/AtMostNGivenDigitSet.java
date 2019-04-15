//Example 1:
//Input: D = ["1","3","5","7"], N = 100
//Output: 20
//Explanation: 
//The 20 numbers that can be written are:
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.

package Medium;

public class AtMostNGivenDigitSet {
	
	public int atMostNGivenDigitSet(String[] D, int N) 
	{
        char[] digits = Integer.toString(N).toCharArray();
        
        int l = digits.length;

        int res = 0;
        
        int d = D.length;
        int[] nums = new int[d];
        
        for (int i = 0; i < d; i++) 
            nums[i] = Integer.valueOf(D[i]);        
        
        // for digits from 1 ~ l - 1;
        for (int i = 1; i <= l - 1; i++) 
            res += Math.pow(d, i);
        
        // for numbers with l digits
        for (int i = 0; i < l; i++) 
        {
            int h = 0;
            // how many digits < digits[]
            while (h < d && nums[h] < (digits[i] - '0')) 
                h++;
            
            res += h * Math.pow(d, (l - i - 1));
            
            if (h == d) 
                break;
            
            if (nums[h] != (digits[i] - '0')) 
                break;
            
            if (i == l - 1) 
                res++;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
