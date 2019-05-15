//Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
//The returned string must have no leading zeroes, unless the string is "0".
//Example 1:
//Input: 2
//Output: "110"
//Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
//base2 function is quite basis of basis.
//check last digit, shift to right.
//base-2 is totally no difference, just add a sign -.
//
//Time Complexity:
//O(logN) Time, O(logN) space.

package Medium;

public class ConvertToBase2 {

	public String baseNeg2(int N) 
	{
        int num = 1;
        while (num < N) 
        	num = (num << 2) + 1;
        return Integer.toBinaryString(num ^ (num - N));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
