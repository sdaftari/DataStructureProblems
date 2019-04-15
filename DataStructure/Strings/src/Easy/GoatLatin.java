//The rules of Goat Latin are as follows:
//If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//For example, the word 'apple' becomes 'applema'. 
//If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//For example, the word "goat" becomes "oatgma". 
//Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
//Example:
//Input: "The quick brown fox jumped over the lazy dog"
//Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

package Easy;
import java.util.*;

public class GoatLatin {
	
	public String toGoatLatin(String S) 
	{
        Set<Character> vowel = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) 
            vowel.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s"))
        {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) 
                res += "a";
        }
        
         return res.substring(1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
