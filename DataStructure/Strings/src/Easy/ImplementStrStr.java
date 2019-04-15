//Example 1:
//Input: haystack = "hello", needle = "ll"
//Output: 2
//Example 2:
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1

package Easy;

public class ImplementStrStr {
	
	public int strStr(String haystack, String needle) 
	{
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2)
            return -1;
        else if (l2 == 0)
            return 0;
        
        int diff = l1 - l2;
        for (int i = 0; i <= diff; i++)
        {
            if (haystack.substring(i, l2+i).equals(needle))
                return i;
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
