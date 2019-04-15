package Medium;
import java.util.*;

public class BTRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) 
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode n = q.poll();
                if(n.left != null) 
                    q.add(n.left);
                if(n.right != null) 
                    q.add(n.right);
                
                // Add size-1 node to list
                if(i == size-1) 
                    list.add(n.val);
            }
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
