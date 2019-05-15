/*
find the shortest string length
use binary search. find mid.
From low to mid, find if that prefix is present in all the strings
if it returns true, put low = mid + 1 and search for second half
else, in first half, reduce the high by 1 and search again
Complexity: O(m*n)
*/

package Medium;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) 
	{
		// length of min string
        int index = findMinimumLength(strs);
        StringBuilder sol = new StringBuilder();
        int low = 0; int high = index;
        if (strs.length > 0)
        {
            while (low <= high)
            {
                int mid = (low + high)/2;
                if (allContainsPrefix(strs, strs.length, strs[0], low, mid))
                {
                    sol.append(strs[0].substring(low, mid+1));
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
        }
        
        return sol.toString();
    }
    
    public boolean allContainsPrefix(String[] strs, int n, String str, int low, int high)
    {
        for (String tempString : strs)
        {
            for(int j = low; j <= high; j++)
            {
                if (tempString.charAt(j) != str.charAt(j))
                    return false;
            }
        }
        
        return true;
    }
    
    public int findMinimumLength(String[] arr)
    {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].length() < minLength)
                minLength = arr[i].length();
        }
        
        return minLength-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
