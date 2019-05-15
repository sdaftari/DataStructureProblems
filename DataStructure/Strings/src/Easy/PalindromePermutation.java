//Given a string, determine if a permutation of the string could form a palindrome.
//
//Example 1:
//
//Input: "code"
//Output: false
//Example 2:
//
//Input: "aab"
//Output: true

package Easy;
import java.util.*;

public class PalindromePermutation {
//	The idea is to iterate over string, adding current character to set if set doesn't contain that character, or removing current character from set if set contains it.
//	When the iteration is finished, just return set.size()==0 || set.size()==1.
//	set.size()==0 corresponds to the situation when there are even number of any character in the string, and
//	set.size()==1 corresponsds to the fact that there are even number of any character except one.
	public boolean canPermutePalindrome(String s) 
	{
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
