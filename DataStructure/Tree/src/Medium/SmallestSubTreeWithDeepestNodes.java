package Medium;

public class SmallestSubTreeWithDeepestNodes {

//	if root == null, return pair(0, null)
//	left = deep(root.left)
//	right = deep(root.left)
//
//	if left depth == right depth,
//	deepest nodes both in the left and right subtree,
//	return pair (left.depth + 1, root)
//
//	if left depth > right depth,
//	deepest nodes only in the left subtree,
//	return pair (left.depth + 1, left subtree)
//
//	if left depth < right depth,
//	deepest nodes only in the right subtree,
//	return pair (right.depth + 1, right subtree)
	
//	public TreeNode subtreeWithAllDeepest(TreeNode root) 
//	{
//        return deep(root).getValue();
//    }
//
//    public Pair<Integer, TreeNode> deep(TreeNode root) {
//        if (root == null) return new Pair(0, null);
//        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);
//
//        int d1 = l.getKey(), d2 = r.getKey();
//        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
