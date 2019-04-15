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
//40      60 90
//For the above test case no sequence is possible: -1

package Medium;

public class LongestContinuousSequence 
{
	int max;
	public int longestConsecutive(TreeNode root)
    {
        helper(root);
        // If no sequence is posiible, return -1
        return max == 1 ? -1 : max;
    }
    
    private int helper(TreeNode t){
        if(t==null){
            return 0;
        }
 
        int leftMax = helper(t.left);
        int rightMax = helper(t.right);
 
        int leftTotal = 0;
        if(t.left == null)
            leftTotal = 1;
        else if(t.val+1 == t.left.val)
            leftTotal = leftMax+1;    
        else
            leftTotal = 1;
 
        int rightTotal = 0;
        if(t.right == null)
            rightTotal = 1;
        else if(t.val+1 == t.right.val)
            rightTotal = rightMax+1;    
        else
            rightTotal = 1;
 
        max = Math.max(max, leftTotal);
        max = Math.max(max, rightTotal);
 
        int longer = Math.max(leftTotal, rightTotal);   
 
        return longer;
    }  

	public static void main(String[] args) {
		LongestContinuousSequence obj = new LongestContinuousSequence();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(obj.longestConsecutive(root));
	}

}
