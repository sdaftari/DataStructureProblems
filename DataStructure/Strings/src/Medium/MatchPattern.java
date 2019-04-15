//Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. 
//The task is to complete a function findMatchedWords(dict,pattern) that returns a vector of strings matching with given pattern. 
//The function takes two argument the first argument is an array of strings dict which denote the dictionary and the second argument is the pattern to match.
//Input
//1
//4
//abb abc xyz xyy
//foo
//
//Output
//abb xyy
//
//Explanation
//Testcase 1: In the above test case xyy and abb have same character at index 1 and 2 like the pattern.

package Medium;
import java.util.*;

public class MatchPattern {
	
	// Function to encode given string 
    static String encodeString(String str) 
    { 
           HashMap<Character, Integer> map = new HashMap<>(); 
           String res = ""; 
           int i = 0; 
             
           // for each character in given string 
           char ch; 
           for (int j = 0; j < str.length(); j++)  
           { 
                ch = str.charAt(j); 

                // If the character is occurring for the first 
                // time, assign next unique number to that char 
                if(!map.containsKey(ch))  
                   map.put(ch, i++); 

                // append the number associated with current 
                // character into the output string 
                res += map.get(ch); 
           } 

           return res; 
    } 

    // Function to print all the strings that match the 
    // given pattern where every character in the pattern is 
    // uniquely mapped to a character in the dictionary 
    static void findMatchedWords(String[] dict, String pattern) 
    { 
           // len is length of the pattern 
           int len = pattern.length(); 
             
           // encode the string 
           String hash = encodeString(pattern); 

           // for each word in the dictionary array 
           for (String word : dict) 
           { 
             // If size of pattern is same as size of current 
             // dictionary word and both pattern and the word 
             // has same hash, print the word 
             if (word.length() == len && encodeString(word).equals(hash)) 
                 System.out.print(word + " "); 
           } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
