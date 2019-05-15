//S and T are strings composed of lowercase letters. In S, no letter occurs more than once. S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that 
//S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string. Return any permutation of T (as a string) that satisfies this property.
//Example :
//Input: 
//S = "cba"
//T = "abcd"
//Output: "cbad"
//Explanation: 
//"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
//Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

package Medium;

public class CustomSortString {
	
	public String customSortString(String S, String T) 
	{
        int[] count = new int[26];
        
        // count each char in T.
        for (char c : T.toCharArray())
            count[c - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        // sort chars both in T and S by the order of S.
        for (char c : S.toCharArray())
            while (count[c - 'a']-- > 0) 
                sb.append(c);    
        
        // group chars in T but not in S.
        for (char c = 'a'; c <= 'z'; c++)
            while (count[c - 'a']-- > 0)    
                sb.append(c);
        
        return sb.toString();
    }

	public static void main(String[] args) {
		String S = "cba", T = "abcd";
		CustomSortString obj = new CustomSortString();
		System.out.println(obj.customSortString(S, T));
	}

}
