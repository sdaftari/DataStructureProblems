//Given a a Binary Tree, your task is to complete the function getLevelDiff which  returns the difference between the sum of nodes at odd level and the sum of nodes at even level . The function getLevelDiff  takes only one argument  ie the root of the binary tree . 
//
//       2
//     /    \
//    3     5
//For the above tree the odd level sum is 2 and even level sum is 8 thus the difference is 2-8=-6

package Easy;
import java.util.*;

public class DiffBetweenOddAndEvenLevels {
	
	public int getLevelDiff(TreeNode root)
    {
        if (root == null)
            return 0;
            
        int level = 0, sumEvenLevel = 0, sumOddLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
            	TreeNode curr = queue.poll();
                if (level % 2 == 0)
                    sumEvenLevel += curr.val;
                else
                    sumOddLevel += curr.val;
                    
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            
            level++;
        }
        
        return sumEvenLevel - sumOddLevel;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
