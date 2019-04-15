//Example 2:
//Input: "  hello world!  "
//Output: "world! hello"
//Explanation: Your reversed string should not contain leading or trailing spaces.
//Example 3:
//Input: "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

package Medium;

public class ReverseWordsInString {
	// Recursive
	public String reverseWords(String s) 
	{
        if (s == null) 
            return null;
    
        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }
    
    void reverseWords(char[] a, int n) 
    {
        int i = 0, j = 0;

        while (i < n) 
        {
          while (i < j || i < n && a[i] == ' ') 
              i++; // skip spaces
          while (j < i || j < n && a[j] != ' ') 
              j++; // skip non spaces
          reverse(a, i, j - 1);                      // reverse the word
        }
	} 
	  
    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) 
    {
      int i = 0, j = 0;
      
      while (j < n) 
      {
        // skip spaces
        while (j < n && a[j] == ' ') 
            j++;    
        // keep non spaces
        while (j < n && a[j] != ' ') 
            a[i++] = a[j++];
        // skip spaces
        while (j < n && a[j] == ' ') 
            j++; 
        // keep only one space
        if (j < n) 
            a[i++] = ' ';                      
      }
  
      return new String(a).substring(0, i);
    }
  
    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) 
    {
      while (i < j) 
      {
        char t = a[i];
        a[i++] = a[j];
        a[j--] = t;
      }
    }
    
    // Reverse String II
    // Reverse string word by word
    public void reverseWords(char[] str) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(str, 0, str.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverseII(str, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(str, start, str.length - 1);
    }
    
    public void reverseII(char[] s, int start, int end) 
    {
        while (start < end) 
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
