//Example 1:
//Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//Output: "1(2(4))(3)"
//
//Explanation: Originallay it needs to be "1(2(4)())(3()())", 
//but you need to omit all the unnecessary empty parenthesis pairs. 
//And it will be "1(2(4))(3)".

package Easy;

public class ConstructStringFromBST {
	
	 public String tree2str(TreeNode t) {
	        if (t == null) 
	            return "";
	        
	        String result = t.val + "";
	        
	        String left = tree2str(t.left);
	        String right = tree2str(t.right);
	        
	        if (left == "" && right == "") 
	            return result;
	        if (left == "") 
	            return result + "()" + "(" + right + ")";
	        if (right == "") 
	            return result + "(" + left + ")";
	        return result + "(" + left + ")" + "(" + right + ")";
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
