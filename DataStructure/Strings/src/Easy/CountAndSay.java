//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//
//Example:
//Input: 4
//Output: "1211"

package Easy;

public class CountAndSay {
	
	public String countAndSay(int n) 
	{
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 1; i < n; i++)
        {
            sb = generateNext(sb);
        }
        
        return sb.toString();
    }
    
    private StringBuilder generateNext(StringBuilder sb)
    {
        StringBuilder next = new StringBuilder();
        int count = 1;
        int index = 1;
        while (index < sb.length())
        {
            if (sb.charAt(index) == sb.charAt(index-1))
                count++;
            else
            {
                next.append(count);
                next.append(sb.charAt(index-1));
                count = 1;
            }
            
            index++;
        }
        
        next.append(count);
        next.append(sb.charAt(index-1));
        return next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
