//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//Example 1:
//Input: num = "123", target = 6
//Output: ["1+2+3", "1*2*3"] 

package Hard;
import java.util.*;

public class AddOperators {
	
	public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) 
        	return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length())
        {
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++)
        {
        	// Since we always start with pos, we can only have 0 at the first place, when i = pos
        	// any number with 2 or more digits cannot have leading zero(s).
            if(i != pos && num.charAt(pos) == '0') 
            	break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            
            if(pos == 0)
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            else
            {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
