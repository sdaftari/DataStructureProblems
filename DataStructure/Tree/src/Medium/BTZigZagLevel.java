   package Medium;
import java.util.*;

public class BTZigZagLevel {
	
	Map<Integer, LinkedList<Integer>> map;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        if (root == null)
            return new LinkedList<>();
        map = new HashMap<>();
        levelOrder(root, 0);
        
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < map.size(); i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    
    private void levelOrder(TreeNode root, int level)
    {
        if (root == null)
            return;
        
        map.putIfAbsent(level, new LinkedList<>());
        // For even level, add the nodes in reverse order, right -> left
        if(level % 2 == 0)
            map.get(level).addLast(root.val);
        else
            map.get(level).addFirst(root.val);
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
