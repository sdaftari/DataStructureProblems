//Example:
//Input: "abcabcababcc"
//Output: true
//Explanation: 
//"abcabcabc" is valid after consecutive insertings of "abc".
//Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
//Example:
//Input: "abccba"
//Output: false

package Medium;

public class ValidWordAfterSubstitutions {
	
	public boolean isValid(String S) {
        String abc = "abc";
    	
    	while(S.contains(abc)) 
    		S = S.replace(abc, "");
    	
        return S.isEmpty();

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
