//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//Output: [7,4,1]

//Explanation: 
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.

package Medium;
import java.util.*;

public class AllNodesAtKDistanceInBT {
	Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) 
            return res;
        
        // Adds parent to child and child to parent to maintain the connectivity
        buildMap(root, null);
        if (!map.containsKey(target)) 
            return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty())
        {
            int size = q.size();
            if (K == 0) 
            {
                for (int i = 0; i < size ; i++) 
                    res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                // For each node, get the connected nodes and add them to visited and q
                for (TreeNode next : map.get(node))
                {
                    if (visited.contains(next)) 
                        continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            // After one level is processed, decrement k
            K--;
        }
        return res;
    }
    
    private void buildMap(TreeNode node, TreeNode parent)
    {
        if (node == null) 
            return;
        if (!map.containsKey(node)) 
        {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  
            { 
                map.get(node).add(parent); 
                map.get(parent).add(node) ; 
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
