//Given two strings a and b. The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.
//Example:
//Input:
//2
//amazon
//azonam
//geeksforgeeks
//geeksgeeksfor
//
//Output:
//1
//0
//
//Explanation:
//Testcase 1: amazon can be rotated anti-clockwise by two places, which will make it as azonam.
//
//Testcase 2: geeksgeeksfor can't be formed by any rotation from the given word geeksforgeeks.

package Easy;

public class StringRotatedByTwpPlaces {
	
	// Method to check if string2 is obtained by 
    // string 1 
    static boolean isRotated(String str1, String str2) 
    { 
        if (str1.length() != str2.length()) 
            return false; 
       
        String clock_rot = ""; 
        String anticlock_rot = ""; 
        int len = str2.length(); 
       
        // Initialize string as anti-clockwise rotation 
        anticlock_rot = anticlock_rot + 
                        str2.substring(len-2, len) + 
                        str2.substring(0, len-2) ; 
       
        // Initialize string as clock wise rotation 
        clock_rot = clock_rot + 
                    str2.substring(2) + 
                    str2.substring(0, 2) ; 
       
        // check if any of them is equal to string1 
        return (str1.equals(clock_rot) || 
                str1.equals(anticlock_rot)); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
