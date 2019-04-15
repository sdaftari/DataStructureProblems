//Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
//Given two anagrams A and B, return the smallest K for which A and B are K-similar.
//Example 1:
//Input: A = "ab", B = "ba"
//Output: 1

package Hard;
import java.util.*;

public class KSimilarStrings {
	
	public int kSimilarity(String A, String B) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(A);
        seen.add(A);
        int res = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                String curr = queue.poll();
                if (curr.equals(B)){
                    return res;
                }
                int j = 0;
                while (j < curr.length() && curr.charAt(j) == B.charAt(j))
                {
                    j++;
                }
                for (int k = j + 1; k < curr.length(); k++)
                {
                    if (curr.charAt(k) == B.charAt(j) && curr.charAt(k) != B.charAt(k))
                    {
                    	//return string to ensure that curr won't change
                        String next = swap(curr, j, k);
                        if (!seen.contains(next))
                        {
                            queue.offer(next);
                            seen.add(next);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
    
    private String swap(String curr, int j, int k){
        char[] arr = curr.toCharArray();
        char temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
        return new String(arr);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
