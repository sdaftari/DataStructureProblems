//You have been given an alphanumeric string S, extract maximum numeric value from that string. Alphabets will only be in lower case.'
//Example:
//Input:
//3
//100klh564abc365bg
//abvhd9sdnkjdfs
//abchsd0sdhs
//Output:
//564
//9
//0
//
//Explanation:
//Test Case 1: The maximum number found in the string is "564".  

package Easy;

public class ExtractMaximum {
	
	// Method to extract the maximum value 
    static String extractMaximum(String str) 
    { 
        int n = str.length(); 
        String curr_num =""; 
        String res=""; 
       
        // Start traversing the string 
        for (int i = 0; i<n; i++) 
        { 
            // Ignore leading zeroes 
            while (i<n && str.charAt(i)=='0') 
                i++; 
       
            // Store numeric value into a string 
            while (i<n && Character.isDigit(str.charAt(i))) 
            { 
                curr_num = curr_num + str.charAt(i); 
                i++; 
            } 
       
            if (i == n) 
                break; 
       
            if (curr_num.length() > 0) 
                i--; 
       
            // Update maximum string 
            res = maximumNum(curr_num, res); 
       
            curr_num = ""; 
        } 
       
        // To handle the case if there is only 
        // 0 numeric value 
        if (curr_num.length() == 0 && res.length() == 0) 
            res = res + '0'; 
       
        // Return maximum string 
        return maximumNum(curr_num, res); 
    } 
    
 // Utility method to find maximum string 
    static String maximumNum(String curr_num, String res) 
    { 
        int len1 = curr_num.length(); 
        int len2 = res.length(); 
       
        // If both having equal lengths 
        if (len1 == len2) 
        { 
            // Reach first unmatched character / value 
            int i = 0; 
            while (curr_num.charAt(i) == res.charAt(i)) 
                i++; 
       
            // Return string with maximum value 
            if (curr_num.charAt(i) < res.charAt(i)) 
                return res; 
            else
                return curr_num; 
        } 
       
        // If different lengths 
        // return string with maximum length 
        return len1 < len2 ? res: curr_num; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
