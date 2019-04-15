package Easy;

public class Subtree {
	
	public boolean isSubtree(TreeNode s, TreeNode t)
	{
		if (serializeTree(s).contains(serializeTree(t)))
			return true;
		return false;		
	}
	
	private String serializeTree(TreeNode node)
	{
		StringBuilder sb = new StringBuilder();
		serialize(node, sb);
		return sb.toString();
	}
	
	private void serialize(TreeNode node, StringBuilder sb)
	{
		if (node == null)
		{
			sb.append("#");
			return;
		}
		
		sb.append(node.val);
		serialize(node.left, sb);
		serialize(node.right, sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
