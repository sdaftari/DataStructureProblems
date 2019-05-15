//Example 1:
//Input: "42"
//Output: 42
//Example 2:
//Input: "   -42"
//Output: -42
//Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.

package Medium;

public class StringToInteger {
	
	public int myAtoi(String str) 
	{
		// Initialize result 
        int res = 0;  
          
        // Initialize sign as positive 
        int sign = 1;  
          
        // Initialize index of first digit 
        int i = 0;  
      
        // If number is negative, then  
        // update sign 
        if (str.charAt(0) == '-') 
        { 
            sign = -1;  
              
            // Also update index of first 
            // digit 
            i++;  
        } 
      
        // Iterate through all digits  
        // and update the result 
        for ( ; i < str.length(); ++i) 
            res = res * 10 + str.charAt(i) - '0'; 
      
        // Return result with sign 
        return sign * res; 
    }
	
	
	// Integer to words
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};  
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) 
    {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
