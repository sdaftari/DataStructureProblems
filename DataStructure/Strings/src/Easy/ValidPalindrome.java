//Example 1:
//Input: "A man, a plan, a canal: Panama"
//Output: true
//Example 2:
//Input: "race a car"
//Output: false

//Valid Palindrome II
//Example 2:
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.

package Easy;

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) 
	{
        if (s.isEmpty())
            return true;
        
        int left = 0;
        int right = s.length()-1;
        while(left < right)
        {
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            
            else if (!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            
            else 
            {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++; right--;
            }
        }
        
        return true;
    }
	
	// Valid Palindrome II (Can delete at most one character)
	public boolean validPalindrome(String s) 
	{
        int l = -1, r = s.length();
	    while (++l < --r) 
	        if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
	    return true;
	}
	
	public boolean isPalindromic(String s, int l, int r) 
	{
	    while (++l < --r) 
	        if (s.charAt(l) != s.charAt(r)) 
	            return false;
	    return true;
	}

	public static void main(String[] args) {
		ValidPalindrome obj = new ValidPalindrome();
		System.out.println(obj.isPalindrome("I am :IronnorI Ma, i"));

	}

}
