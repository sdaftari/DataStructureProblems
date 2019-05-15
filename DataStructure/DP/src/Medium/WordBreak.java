//Example 2:
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//             Note that you are allowed to reuse a dictionary word.
// Time: O(n^3) Space: O(n^2)

package Medium;
import java.util.*;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) 
	{
        int T[][] = new int[s.length()][s.length()];
        
        for(int i = 0; i < T.length; i++)
        {
            for(int j = 0; j < T[i].length ; j++)
            {
                //-1 indicates string between i to j cannot be split
                T[i][j] = -1; 
            }
        }
        
        //fill up the matrix in bottom up manner
        // We will consider l characters each time.
        for(int l = 1; l <= s.length(); l++)
        {
            for(int i = 0; i < s.length() -l + 1 ; i++)
            {
            	//Consider string between i and j equal to length l 
                int j = i + l - 1;
                String str = s.substring(i, j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(wordDict.contains(str))
                {
                    T[i][j] = i;
                    continue;
                }
                
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k = i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1)
                    {
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        
        if(T[0][s.length()-1] == -1)
            return false;
        
        return true;
    }

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");
		WordBreak obj = new WordBreak();
		System.out.print(obj.wordBreak(s, wordDict));
	}

}
