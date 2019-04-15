package Easy;
import java.util.*;

public class SameTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q)     {
        // if (p == null && q == null) 
        //     return true;
        // if (p == null && q != null || p != null && q == null)                   
        //     return false;
        // if (p.val != q.val) 
        //     return false;
        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        // Iterative
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.empty() && !stackQ.empty())
        {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val)
                return false;
            else if (tmpP.left != null && tmpQ.left != null)
            {
                stackP.push(tmpP.left);
                stackQ.push(tmpQ.left);
            }
            else if (tmpP.left != null || tmpQ.left != null)
                return false;
            
            if (tmpP.right != null && tmpQ.right != null)
            {
                stackP.push(tmpP.right);
                stackQ.push(tmpQ.right);
            }
            else if (tmpP.right != null || tmpQ.right != null)
                return false;
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
