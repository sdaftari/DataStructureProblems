//Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
//Example 1:
//Input: "eceba"
//Output: 3
//Explanation: t is "ece" which its length is 3.

// At the most k distinct
//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//Example 1:
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: T is "ece" which its length is 3.

package Medium;
import java.util.*;

public class LengthOfLongestSubstringWithTwoDistinct {
	
	public int lengthOfLongestSubstringTwoDistinct(String s) 
	{
        if(s.length() < 1) 
        	return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) 
        {
            if(index.size() <= 2) 
            {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) 
            {
                int leftMost = s.length();
                for(int i : index.values()) 
                    leftMost = Math.min(leftMost,i);
                
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }
	
	// lengthOfLongestSubstringKDistinct
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
