//Given a decimal number m. Convert it in binary string and apply n iterations, in each iteration 0 becomes 01 and 1 becomes 10. Find kth character in the string after nth iteration.
//Example:
//Input:
//2
//5 5 3
//11 6 4
//
//Output:
//1
//1

package Medium;

public class IThCharacterInString {
	static String s = ""; 
	static String ReverseString(String s) 
	{ 
	    char[] arr = s.toCharArray(); 
	    for(int i = 0; i < arr.length / 2; i++) 
	    { 
	        char temp = arr[i];  
	        arr[i] = arr[arr.length - i -1];  
	        arr[arr.length - i - 1] = temp;  
	    } 
	    return new String(arr); 
	} 
	  
	// Function to store binary Representation 
	static void binary_conversion(int m)  
	{ 
	    while (m != 0)  
	    { 
	        int tmp = m % 2; 
	        s += Integer.toString(tmp); 
	        m = (int)(m / 2); 
	    } 
	      
	    s = ReverseString(s); 
	} 
	  
	// Function to find ith character 
	static int find_character(int n, int m,  int i)  
	{      
	    // Function to change decimal to binary 
	    binary_conversion(m); 
	  
	    String s1 = ""; 
	    for (int x = 0; x < n; x++)  
	    { 
	        for (int y = 0; y < s.length(); y++)  
	        { 
	            if (s.charAt(y) == '1')  
	            	s1 += "10"; 
	            else
	            	s1 += "01";      
	        } 
	          
	        // Assign s1 String  
	        // in s String 
	        s = s1; 
	        s1 = ""; 
	    } 
	      
	    return s.charAt(i) - '0'; 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
