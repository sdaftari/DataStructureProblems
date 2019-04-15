//Example 1:
//Input: "aabcbc"
//Output: true
//Explanation: 
//We start with the valid string "abc".
//Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".

package Easy;

public class IsValidAfterSubstitution {
	
	public boolean isValid(String S) 
	{
        String abc = "abc";
    	
    	while(S.contains(abc)) 
    		S = S.replace(abc, "");
    	
        return S.isEmpty();

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
