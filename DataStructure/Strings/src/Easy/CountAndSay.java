//The count-and-say sequence is the sequence of integers with the first five terms as following:
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n where 1 <= n <= 30, generate the nth term of the count-and-say sequence.
//Note: Each term of the sequence of integers will be represented as a string.

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
