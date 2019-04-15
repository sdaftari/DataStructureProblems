package Easy;
import java.util.*;

public class BTPaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if (root != null)
            treePaths(root, "", paths); 
        return paths;
    }
    
    private void treePaths(TreeNode root, String currPath, ArrayList<String> paths)
    {
        if (root.left == null && root.right == null)
            paths.add(currPath + root.val);
        
        if (root.left != null)
            treePaths(root.left, currPath + root.val + "->", paths);
        
        if (root.right != null)
            treePaths(root.right, currPath + root.val + "->", paths);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
