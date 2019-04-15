//Testcase 1: For the array parent[] = {-1, 0, 0, 1, 1, 3, 5}; the tree generated will have a sturcture like
//
//         0
//       /   \
//      1     2
//     / \
//    3   4
//   /
//  5
///
//6

package Medium;

public class ConstructBTFromParentArray {
	static TreeNode root; 
    public static TreeNode construcTree(int arr[], int n)
    {
        // Create an array created[] to keep track 
        // of created nodes, initialize all entries 
        // as NULL 
    	TreeNode[] created = new TreeNode[n]; 
        for (int i = 0; i < n; i++)  
            created[i] = null; 
   
        for (int i = 0; i < n; i++) 
            createNode(arr, i, created); 
   
        return root; 
    }
    
    // Creates a node with key as 'i'.  If i is root, then it changes 
    // root.  If parent of i is not created, then it creates parent first 
    static void createNode(int parent[], int i, TreeNode created[])  
    { 
        // If this node is already created 
        if (created[i] != null) 
            return; 
   
        // Create a new node and set created[i] 
        created[i] = new TreeNode(i); 
   
        // If 'i' is root, change root pointer and return 
        if (parent[i] == -1)  
        { 
            root = created[i]; 
            return; 
        } 
   
        // If parent is not created, then create parent first 
        if (created[parent[i]] == null) 
            createNode(parent, parent[i], created); 
   
        // Find parent pointer 
        TreeNode p = created[parent[i]]; 
   
        // If this is first child of parent 
        if (p.left == null) 
            p.left = created[i]; 
        else // If second child 
           
            p.right = created[i]; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
