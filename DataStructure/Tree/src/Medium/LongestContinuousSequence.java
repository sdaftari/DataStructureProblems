//input:
//2
//2
//1 2 L 1 3 R
//5
//10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
//Output:
//
//2
//-1
//Explanation:
//Test case 1:
//
//           1
//
//        /     \
//
//      2        3
//
//For the above test case the longest sequence is : 1 2 
//Test case 2:
//
//            10
//
//         /        \
//
//     20          30
//
//   /      \       /
//
//40         60   90
//For the above test case no sequence is possible: -1
// Time: O(N)

package Medium;

public class LongestContinuousSequence 
{
	int max;
	public int longestConsecutive(TreeNode root)
    {
		if (root == null) 
            return 0;
		
        int left = longestConsecutive(root.left);
        int right = longestConsecutive(root.right);
        int len = getLength(root);
        return Math.max(len, Math.max(left, right));
    }
    
	private int getLength(TreeNode root) 
    {
        if (root == null) 
            return 0;
        
        int left = 1;
        int right = 1;
        if (root.left != null) 
        {
            if (root.val + 1 == root.left.val) 
                left += getLength(root.left);
        }
        if (root.right != null) 
        {
            if (root.val + 1 == root.right.val) 
                right += getLength(root.right);
        }
        return Math.max(left, right);
    }  

	public static void main(String[] args) {
		LongestContinuousSequence obj = new LongestContinuousSequence();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(obj.longestConsecutive(root));
	}

}
