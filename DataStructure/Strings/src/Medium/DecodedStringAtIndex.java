// O(N)
package Medium;

public class DecodedStringAtIndex {

	public static void main(String[] args) {
		DecodedStringAtIndex obj = new DecodedStringAtIndex();
		System.out.print(obj.decodeAtIndex("ha22", 5));
	}
	
	public String decodeAtIndex(String S, int K) 
	{
        long N = 0L;
        int i;
        char[] chs = S.toCharArray();
        for (i = 0; N < K; i++)
        	// If the current character is digit, multiply N with that digit. So N will be total length of string or equal to k
            N = Character.isDigit(chs[i]) ? N * (chs[i] - '0') : N+1;
            
        // Once we get all characters greater than or equal to k
        i--;
        while (true)
        {        	
            if (Character.isDigit(chs[i]))
            {
            	// If its a digit, divide N to reduce the last repetition
                N /= chs[i] - '0';
                
                // Take the modulo for K with the remaining letters
                K %= N;
            }
            
            // If K%N = 0, return the character else decrement N and i
            else if (K % N == 0)
                return ""+chs[i];
            else
                N--;
            i--;
        }
    }
}
