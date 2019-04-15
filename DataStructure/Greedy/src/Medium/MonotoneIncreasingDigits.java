//Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
//(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
//Example 3:
//Input: N = 332
//Output: 299

package Medium;

public class MonotoneIncreasingDigits {
	
	public int monotoneIncreasingDigits(int N) {
        char[] x = String.valueOf(N).toCharArray();
        int mark = x.length;
        // If there is any decreasing pattern present in the number,
        // The result will be one less than the first digit and rest of the digits to be 99....
        for(int i = x.length-1;i>0;i--)
        {
            // mark points to the first location of the largest number
            if(x[i]<x[i-1])
            {
                mark = i-1;
                x[i-1]--;
            }
        }
        
        for(int i = mark+1;i<x.length;i++)
            x[i] = '9';
        
        return Integer.parseInt(new String(x));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
