package Easy;
import java.util.*;

public class ConvertSortedArrayToBST {

	public class MyNode
    {
        TreeNode node;
        int start, end;
        
        public MyNode(int start, int end, TreeNode node)
        {
            this.start = start;
            this.end = end;
            this.node = node;
        }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        Stack<MyNode> stack = new Stack<>();
        int mid = 0 + (nums.length-1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        MyNode myNode = new MyNode(0, nums.length-1, root);
        stack.push(myNode);
        while(!stack.isEmpty())
        {
            MyNode curr = stack.pop();
            int currMid = curr.start + (curr.end-curr.start)/2;
            if(currMid - 1 >= curr.start)
            {
                mid = curr.start + (currMid-1 - curr.start)/2;
                root = new TreeNode(nums[mid]);
                stack.push(new MyNode(curr.start, currMid-1, root));
                curr.node.left = root;
            }
            
            if(currMid+1 <= curr.end)
            {
                mid = currMid + 1 + (curr.end-currMid-1)/2;
                root = new TreeNode(nums[mid]);
                stack.push(new MyNode(currMid+1, curr.end, root));
                curr.node.right = root;
            }
        }
        
        return myNode.node;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
