package Medium;
import java.util.*;
public class GenerateParanthesis {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		backtrack(list, new StringBuilder(), 0, 0, 3);
        System.out.println(list);;
	}
	
	public static void backtrack(List<String> list, StringBuilder str, int open, int close, int max)
	{
	        // If we have max length, add it to the result and return
		if(str.length() == max*2)
        {
            list.add(str.toString());
            return;
        }
        
        if(open < max)
        {
            backtrack(list, str.append("("), open+1, close, max);
            str.deleteCharAt(str.length()-1);
        }
            
        if(close < open)
        {
            backtrack(list, str.append(")"), open, close+1, max);
            str.deleteCharAt(str.length()-1);
        }
	}
}