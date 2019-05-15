//Example:
//Input: [1000,100,10,2]
//Output: "1000/(100/10/2)"
//Explanation:
//1000/(100/10/2) = 1000/((100/10)/2) = 200
//However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
//since they don't influence the operation priority. So you should return "1000/(100/10/2)". 
//
//Other cases:
//1000/(100/10)/2 = 50
//1000/(100/(10/2)) = 50
//1000/100/10/2 = 0.5
//1000/100/(10/2) = 2

// X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses. i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator. 
// Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn. So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
// Time: O(N)

package Medium;

public class OptimalDivision {

	public String optimalDivision(int[] nums) 
	{
        String ret = "";
        if (nums.length == 0) 
            return ret;
        
        if (nums.length == 1) 
        {
            ret = Integer.toString(nums[0]);
            return ret;
        }
        if (nums.length == 2) 
        {
            ret = Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
            return ret;
        }
        
        ret = Integer.toString(nums[0]) + "/(" + Integer.toString(nums[1]);
        for (int i = 2; i < nums.length; i++) 
            ret += "/" + Integer.toString(nums[i]);
        
        ret += ")";
        return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
