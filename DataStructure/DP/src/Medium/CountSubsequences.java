//Given a string s, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.
//Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
//Examples:
//Input  : abbc
//Output : 3
//Subsequences are abc, abc and abbc
//
//Input  : abcabc
//Output : 7
//Subsequences are abc, abc, abbc, aabc
//abcc, abc and abc

// Time: O(n)

package Medium;

public class CountSubsequences {
	
	static int countSubsequences(String s) 
    { 
        // Initialize counts of different subsequences 
        // caused by different combination of 'a' 
        int aCount = 0; 
       
        // Initialize counts of different subsequences 
        // caused by different combination of 'a' and 
        // different combination of 'b' 
        int bCount = 0; 
       
        // Initialize counts of different subsequences 
        // caused by different combination of 'a', 'b' 
        // and 'c'. 
        int cCount = 0; 
       
        // Traverse all characters of given string 
        for (int i=0; i< s.length(); i++) 
        { 
            /* If current character is 'a', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence. 
                 b) Current character is part of aCount 
                    subsequences. 
                 c) Current character is not part of 
                    aCount subsequences. */
            if (s.charAt(i) == 'a') 
                aCount = (1 + 2 * aCount); 
       
            /* If current character is 'b', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence of b's with aCount 
                    subsequences. 
                 b) Current character is part of bCount 
                    subsequences. 
                 c) Current character is not part of 
                    bCount subsequences. */
            else if (s.charAt(i) == 'b') 
                bCount = (aCount + 2 * bCount); 
       
            /* If current character is 'c', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence of c's with bCount 
                    subsequences. 
                 b) Current character is part of cCount 
                    subsequences. 
                 c) Current character is not part of 
                    cCount subsequences. */
            else if (s.charAt(i) == 'c') 
                cCount = (bCount + 2 * cCount); 
        } 
       
        return cCount; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
