//Example 1:
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

// Time: O(N) and Space: O(1)

package Medium;
import java.util.*;

public class PartitionLabels {
	
	public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return null;
        
        List<Integer> list = new ArrayList<>();
        
        // record the last index of the each char
        int[] map = new int[26];  
        for(int i = 0; i < S.length(); i++)
            map[S.charAt(i)-'a'] = i;
        
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++)
        {
            // Since last will be set to max value of the letter, it wont add even if last index of b or c is encountered
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i)
            {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
