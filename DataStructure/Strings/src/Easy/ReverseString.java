//Example 1:
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
//Example 2:
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
//Time: O(n)

package Easy;

public class ReverseString {
	
	public void reverseString(char[] s) 
	{
        int i = 0;
        int j = s.length - 1;
        while (i < j) 
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
