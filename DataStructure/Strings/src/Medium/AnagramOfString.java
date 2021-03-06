                                                                                                //Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find minimum number of characters to be 
//deleted to make both the strings anagram. If two strings contains same data set in any order then strings are called Anagrams.
//Examples :
//
//Input : str1 = "bcadeh" str2 = "hea"
//Output: 3
//We need to remove b, c and d from str1.
//
//Input : str1 = "cddgk" str2 = "gcd"
//Output: 2
//
//Input : str1 = "bca" str2 = "acb"
//Output: 0
//Time Complexity : O(n)

package Medium;

public class AnagramOfString {
	final static int CHARS = 26; 
	  
    static int countDeletions(String str1, String str2) { 
        int arr[] = new int[CHARS]; 
        for (int i = 0; i < str1.length(); i++) { 
            arr[str1.charAt(i) - 'a']++; 
        } 
  
        for (int i = 0; i < str2.length(); i++) { 
            arr[str2.charAt(i) - 'a']--; 
        } 
  
        int ans = 0; 
        for (int i = 0; i < CHARS; i++) { 
            ans += Math.abs(arr[i]); 
        } 
        return ans; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
