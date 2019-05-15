//Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
//Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

package Medium;

public class SmallestStringStartingFromLeaf {
	
	public String smallestFromLeaf(TreeNode root) 
	{
        return helper(root);
    }
	
    public String helper(TreeNode root)
    {
        if(root != null)
        {
            String l = helper(root.left);
            String r = helper(root.right);
            if(l.length() > 0 && r.length() > 0)
                return (( (l.compareTo(r) < 0) ? l: r) + (char)(root.val + 'a'));
            else if(l.length() > 0)
                return l + (char)(root.val+'a');
            else
                return r + (char)(root.val+'a');
        }
        return "";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
