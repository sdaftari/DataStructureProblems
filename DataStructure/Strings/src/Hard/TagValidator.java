//Input: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
//Output: True
//Explanation: The code is wrapped in a closed tag : <DIV> and </DIV>. The TAG_NAME is valid, the TAG_CONTENT consists of some characters and cdata. Although CDATA_CONTENT has unmatched start tag with invalid 
//TAG_NAME, it should be considered as plain text, not parsed as tag. So TAG_CONTENT is valid, and then the code is valid. Thus return true.
//Input: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
//Output: True
//Explanation: We first separate the code into : start_tag|tag_content|end_tag. 
//start_tag -> "<DIV>"
//end_tag -> "</DIV>"
//tag_content could also be separated into : text1|cdata|text2.
//text1 -> ">>  ![cdata[]] "
//cdata -> "<![CDATA[<div>]>]]>", where the CDATA_CONTENT is "<div>]>"
//text2 -> "]]>>]"
//The reason why start_tag is NOT "<DIV>>>" is because of the rule 6.
//The reason why cdata is NOT "<![CDATA[<div>]>]]>]]>" is because of the rule 7.

package Hard;
import java.util.*;

public class TagValidator {

	public boolean isValid(String code) 
	{
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < code.length();)
        {
            if(i>0 && stack.isEmpty()) 
                return false;
            if(code.startsWith("<![CDATA[", i))
            {
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i < 0) return false;
                i += 3;
            }
            else if(code.startsWith("</", i))
            {
                int j = i + 2;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) 
                    return false;
                for(int k = j; k < i; k++)
                    if(!Character.isUpperCase(code.charAt(k))) 
                        return false;
                String s = code.substring(j, i++);
                if(stack.isEmpty() || !stack.pop().equals(s)) 
                    return false;
            }
            else if(code.startsWith("<", i))
            {
                int j = i + 1;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++)
                    if(!Character.isUpperCase(code.charAt(k))) 
                        return false;
                String s = code.substring(j, i++);
                stack.push(s);
            }
            else
                i++;
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
