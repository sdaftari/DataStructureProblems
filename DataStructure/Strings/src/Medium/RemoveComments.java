//Example 2:
//Input: 
//source = ["a/*comment", "line", "more_comment*/b"]
//Output: ["ab"]
//Explanation: The original source string is "a/*comment\nline\nmore_comment*/b", where we have bolded the newline characters. After deletion, the implicit newline characters are deleted, leaving the string "ab", 
//which when delimited by newline characters becomes ["ab"].

package Medium;
import java.util.*;

public class RemoveComments {
	
	public List<String> removeComments(String[] source) 
	{
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();     
        boolean mode = false;
        for (String s : source)
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (mode)
                {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/')
                    {
                        mode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                }
                else
                {
                    //ignore remaining characters on line s
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/')
                        break;
                    //skip '*' on next iteration of i
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*')
                    {
                        mode = true;
                        i++;           
                    }
                    //not a comment
                    else    
                        sb.append(s.charAt(i));    
                }
            }
            
            if (!mode && sb.length() > 0)
            {
                res.add(sb.toString());
                //reset for next line of source code
                sb = new StringBuilder();   
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
