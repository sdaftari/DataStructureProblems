//Example:
//
//Input: root = [4,2,5,1,3], target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//Output: 4

// Time: O(n)

package Easy;

public class ClosestBSTValue {
	
	public class TreeNode 
	{
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closestValue(TreeNode root, double target) {
        int ret = root.val;   
        while(root != null)
        {
            if(Math.abs(target - root.val) < Math.abs(target - ret))
                ret = root.val;
              
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }
}
