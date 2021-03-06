//Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = �aabcbcdbca�, then the result would be 4 as of the smallest window will be �dbca� .
//
//Examples:
//
//Input  : aabcbcdbca
//Output : dcba
//Explanation : 
//dbca of length 4 is the smallest 
//window with highest number of distinct
//characters.         
//
//Input : aaab
//Output : ab
//Explanation : 
//ab of length 2 is the smallest window 
//with highest number of distinct characters.
//
//1- Count all distinct characters in given string.
//2- We basically maintain a window of characters. Whenever the window contains all characters of given string, we shrink the window from left side to remove extra characters and 
//then compare its length with smallest window fount so far.

package Medium;
import java.util.*;

public class SmallestDistinctWindow {

	static final int MAX_CHARS = 256; 
    
    // Function to find smallest window containing 
    // all distinct characters 
    static String findSubString(String str) 
    { 
        int n = str.length(); 
       
        // Count all distinct characters. 
        int dist_count = 0; 
          
        boolean[] visited = new boolean[MAX_CHARS]; 
        Arrays.fill(visited, false); 
        for (int i=0; i<n; i++) 
        { 
            if (visited[str.charAt(i)] == false) 
            { 
                visited[str.charAt(i)] = true; 
                dist_count++; 
            } 
        } 
       
        // We basically maintain a window of characters that contains all characters of given string.   
        int start = 0, start_index = -1; 
        int min_len = Integer.MAX_VALUE; 
       
        int count = 0; 
        int[] curr_count =  new int[MAX_CHARS]; 
        for (int j=0; j<n; j++) 
        { 
            // Count occurrence of characters of string 
            curr_count[str.charAt(j)]++; 
       
            // If any distinct character matched, then increment count 
            if (curr_count[str.charAt(j)] == 1 ) 
                count++; 
       
            // if all the characters are matched 
            if (count == dist_count) 
            { 
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of times 
                // than its occurrence in pattern, if yes 
                // then remove it from starting and also remove 
                // the useless characters. 
                while (curr_count[str.charAt(start)] > 1) 
                { 
                    if (curr_count[str.charAt(start)] > 1) 
                        curr_count[str.charAt(start)]--; 
                    start++; 
                } 
                  
                // Update window size 
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index+min_len); 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
