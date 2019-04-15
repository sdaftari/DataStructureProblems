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
        boolean flag_positive = true;
        char tmp_c;
        long r = 0;
        
        if (str == null || (str = str.trim()).length() == 0)    return 0;
        
        if (str.startsWith("-") || str.startsWith("+"))
        {
            if (str.startsWith("-"))
                flag_positive = false;
            str = str.substring(1);
        }
        
        if (str.length() == 0 || !((tmp_c = str.charAt(0)) >= '0' || tmp_c <= '9'))
            return 0;
        
        for (int i = 0, tmp_i = 0, max = str.length(); i < max && (tmp_c = str.charAt(i)) >= '0' && tmp_c <= '9'; i++)
        {
            tmp_i = Integer.parseInt(tmp_c + "");
            r = r * 10 + tmp_i;
            if (r > Integer.MAX_VALUE)
                return flag_positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return (int) (flag_positive ? r : -r);
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
