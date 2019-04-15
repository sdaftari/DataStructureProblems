package Easy;

public class EvaluateTreeExpression {
	class Node
	{
	    String data;
	    Node left,right;
	    Node(String data)
	     {
		 this.data = data;
		 this.left = null;
		 this.right = null;
	     }
	}
	
	public int evalTree(Node root)
    {
        if (root == null)
          return 0;
      
        if (root.left == null && root.right == null)
        {
            return Integer.parseInt(root.data);
        }
          
        int l_val = evalTree(root.left);
        int r_val = evalTree(root.right);
        
        switch(root.data)
        {
            case "+":
                return l_val + r_val; 
                
            case "-":
                return l_val - r_val; 
                
            case "*":
                return l_val * r_val; 
                
            case "/":
                return l_val / r_val; 
        }
        
        return 1; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
