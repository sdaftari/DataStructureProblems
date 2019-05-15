//Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
//Example:
//Input:
//2
//6
//aaa bbb ccc bbb aaa  aaa
//6
//geeks for geeks for geeks aaa
//
//Output:
//bbb
//for

package Medium;
import java.util.*;

public class SecondMostRepeatedString {	
	static String secMostRepeated(List<String> seq)
	{
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < seq.size(); i++)
		{
			if (!map.containsKey(seq.get(i)))
				map.put(seq.get(i), 0);
			map.put(seq.get(i), map.get(seq.get(i))+1);
		}
			
		int maxFirst = Integer.MIN_VALUE;
		int maxSec = Integer.MIN_VALUE;
		String firstKey = "";
		String secKey = "";
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > maxFirst)
			{			
				secKey = firstKey;
				maxSec = maxFirst;
				firstKey = entry.getKey();
				maxFirst = entry.getValue();	
				
			}
			else if (entry.getValue() > maxSec)
			{
				secKey = entry.getKey();
				maxSec = entry.getValue();
			}
		}
			
		return secKey;
	}

	public static void main(String[] args) {
		String arr[] = { "geeks", "for", "geeks", "for", "geeks", "aaa" }; 
		List<String> seq =  Arrays.asList(arr);
		System.out.println(secMostRepeated(seq)); 
	}

}
