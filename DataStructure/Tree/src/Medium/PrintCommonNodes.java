// Time O(n) ... Space O(n) where n > m

package Medium;
import java.util.*;

public class PrintCommonNodes {
	
	public void printCommon(TreeNode root1,TreeNode root2)
    {
        Stack<TreeNode> p = new Stack<>();
        Stack<TreeNode> q = new Stack<>();
        TreeNode pNode = root1;
        TreeNode qNode = root2;
        while(true)
        {
            if (pNode != null)
            {
                p.push(pNode);
                pNode = pNode.left;
            }
            else if (qNode != null)
            {
                q.push(qNode);
                qNode = qNode.left;
            }
            else if (!p.isEmpty() && !q.isEmpty())
            {
                pNode = p.peek();
                qNode = q.peek();
                
                if(pNode.val < qNode.val)
    			{
    				p.pop();
    				pNode = pNode.right;
    				qNode = null;
    			}
    			else if(qNode.val < pNode.val)
    			{
    				q.pop();
    				qNode = qNode.right;
    				pNode = null;
    			}
    			else
    			{
    				System.out.println(pNode.val + " ");
    				p.pop();
    				q.pop();
    				pNode = pNode.right;
    				qNode = qNode.right;
    			}
		    }
		    else
		        break;
        }
		
    }

	public static void main(String[] args) {
		PrintCommonNodes obj = new PrintCommonNodes();
//		TreeNode root1 = new TreeNode(5);
//		root1.left = new TreeNode(1);
//		root1.right = new TreeNode(10);
//		
//		root1.left.left = new TreeNode(0);
//		root1.left.right = new TreeNode(4);
//		
//		root1.right.left = new TreeNode(7);
//		
//		root1.right.left.right = new TreeNode(9);
//		
//		TreeNode root2 = new TreeNode(10);
//		root2.left = new TreeNode(7);
//		root2.right = new TreeNode(20);
//		
//		root2.left.left = new TreeNode(4);
//		root2.left.right = new TreeNode(9);
//		
//		obj.printCommon(root1, root2);
		
		TreeNode root1 = new TreeNode(40);
		root1.left = new TreeNode(30);
		root1.right = new TreeNode(80);
		
//		root1.left.left = new TreeNode(0);
		root1.left.right = new TreeNode(35);
		
//		root1.right.left = new TreeNode(7);
		root1.right.right = new TreeNode(100);
		
//		root1.right.left.right = new TreeNode(9);
		
		TreeNode root2 = new TreeNode(40);
		root2.left = new TreeNode(30);
		root2.right = new TreeNode(80);
		
		root2.left.right = new TreeNode(32);
		root2.left.right.right = new TreeNode(35);
		
		root2.right.right = new TreeNode(90);
		root2.right.right.right = new TreeNode(100);
		root2.right.right.right.right = new TreeNode(120);
		
		obj.printCommon(root1, root2);
	}

}
