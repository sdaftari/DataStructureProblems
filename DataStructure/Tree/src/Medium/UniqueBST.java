// Particularly, the bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).
// i.e.
// G(0)=1, G(1)=1. 
// Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BST with the specified root F(i), is the cartesian product of the number of BST for its left and right subtrees.
// For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, 
// we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product). 
// The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).
// i.e.
// F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
//Example:
//
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

package Medium;
import java.util.*;;
public class UniqueBST {
	
	public int numTrees(int n) {
        int [] G = new int[n+1];
        // G[0] and G[1] represents when there is no node or only one node, #unique BST = 1
        G[0] = G[1] = 1;
        
        // Now starting from 2 nodes for each node i
        for(int i = 2; i <= n; i++)
        {
        	// We have to consider #unique BST for the nodes on its left and # unique BST on its right
        	// And combine them using a cartesian product
            for(int j = 1; j <= i; j++) 
    		    G[i] += G[j-1] * G[i-j];
        }
        
        return G[n];
    }
	
	// Unique BST II
	public List<TreeNode> generateTrees(int n) {
		return generateSubtrees(1, n);
	}

	private List<TreeNode> generateSubtrees(int s, int e) {
		List<TreeNode> res = new LinkedList<TreeNode>();
		if (s > e) {
			res.add(null); // empty tree
			return res;
		}

		for (int i = s; i <= e; ++i) {
			List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

			for (TreeNode left : leftSubtrees) {
				for (TreeNode right : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		UniqueBST obj = new UniqueBST();
		System.out.println(obj.numTrees(3));

	}

}
