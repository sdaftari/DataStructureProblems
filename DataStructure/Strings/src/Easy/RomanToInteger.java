//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//Example 4:
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
//Example 5:
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

package Easy;
import java.util.*;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] sc = s.toCharArray();
        int total = map.get(sc[0]);
        int pre = map.get(sc[0]);
        
        for(int i = 1; i < sc.length; i++)
        {
            int cur = map.get(sc[i]);
            if(cur <= pre)
                total += cur;
            else
                total = total + cur - 2 * pre;
            pre = cur;
        }
        
        return total;
    }
	
	public String intToRoman(int num) 
	{
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
