//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given a non-empty string containing only digits, determine the total number of ways to decode it.
//Example:
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

//Number of Decodings II
//Example 1:
//Input: "*"
//Output: 9
//Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

package Medium;

public class DecodeWays {
	
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) 
        {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        // If string is empty
        dp[0] = 1;
        // First char
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i = 2; i <= n; i++) 
        {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) 
               dp[i] += dp[i-1];  
            if(second >= 10 && second <= 26) 
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
	
	// Has * in input representing one of the number from 1 to 9
	public int numDecodingsII(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        // if s has only one character, return res[0]
        if(s.length() < 2) return (int)res[0];
        
        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        
        for(int j = 2; j < s.length(); j++)
        {
        	long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) /*% 1000000007*/;
            res[0] = temp;
        }
        
        return  (int)res[1];
    }
    
    // returns number of ways considering 2 chars at a time only
	private static int ways(char ch1, char ch2)
	{
		String str = "" + ch1 + "" + ch2;
		// If no *, return 1 way, as both digits are numbers
		if (ch1 != '*' && ch2 != '*')
		{
			if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
		}
		// if both are *, 11-19 and 21-26 = 15
		else if(ch1 == '*' && ch2 == '*') 
            return 15;
		else if(ch1 == '*') 
		{
			// it can be any number from 10-16 or 20-26. 
			// so if ch = 2, it can be 12 or 22
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            // Otherwise it can be 17/18/19
            else
                return 1;
        }
		else 
		{
			// 11-19
            if(Integer.parseInt(""+ch1) == 1 ) 
                return 9;
            // 21-26
            else if(Integer.parseInt(""+ch1) == 2 ) 
                return 6;
		}
		
		return 0;
	}
	
	private static int ways(char ch)
	{
		if (ch == '*')
			return 9;
		if (ch == '0')
			return 0;
		
		return 1;
	}

	public static void main(String[] args) {
		DecodeWays obj = new DecodeWays();
		System.out.println(obj.numDecodings("123"));
	}

}
