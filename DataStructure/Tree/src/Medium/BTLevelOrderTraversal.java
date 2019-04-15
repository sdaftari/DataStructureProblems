//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

package Medium;
import java.util.*;

public class BTLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;        
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
				currLevel.add(currNode.val);
                if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
            }
            
            ans.add(currLevel);
        }
        
        return ans;
    }
	
	// Prints leaves to root from left to right
	// 10 20 L 10 30 R 20 40 L 20 60 R : 40 60 20 30 10
	void reversePrint(Node root) 
    {
        Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		q.add(root);// add the root node to the queue
		while (!q.isEmpty()) 
		{
			// add the children to the queue
			Node n = q.remove();
				
			if (n.right != null) 
				q.add(n.right);
				
			if (n.left != null) 
				q.add(n.left);
				
			// add the extracted node to the Stack
			s.add(n);
		}
		// now print all the Node in Stack
		while (s.isEmpty() == false) {
			System.out.print(s.pop().val + " ");
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
