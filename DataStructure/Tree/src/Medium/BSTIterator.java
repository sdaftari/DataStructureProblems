package Medium;
import java.util.*;

public class BSTIterator {
	
	Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    public void pushAll(TreeNode node)
    {
        while(node != null)
        {
            stack.push(node);
            node = node.left;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
