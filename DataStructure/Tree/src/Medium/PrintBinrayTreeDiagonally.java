package Medium;
import java.util.*;

public class PrintBinrayTreeDiagonally {
	public void diagonalPrint(TreeNode root)
    {
        // base case  
        if (root == null)  
            return;  
        
        // inbuilt queue of Treenode  
        Queue<TreeNode> q= new LinkedList<TreeNode>();  
        
        // add root  
        q.add(root);  
        
        // add delimiter  
        q.add(null);  
        
        while (q.size()>0) 
        {
            TreeNode temp = q.poll();
        
            // if current is delimiter then insert another  
            // for next diagonal and cout nextline  
            if (temp == null) 
            {  
        
                // if queue is empty return  
                if (q.size()==0)  
                    return;  
        
                // add delimiter again  
                q.add(null);  
            }  
            else 
            {
                while (temp != null) 
                {  
                    System.out.print( temp.val + " ");  
        
                    // if left child is present add into queue  
                    if (temp.left!=null)  
                        q.add(temp.left);  
        
                    // current equals to right child  
                    temp = temp.right;  
                }
            }  
        }         
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
