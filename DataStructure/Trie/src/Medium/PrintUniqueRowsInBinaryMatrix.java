//1
//3 4
//1 1 0 1 1 0 0 1 1 1 0 1
//
//Output
//1 1 0 1 $1 0 0 1 $
//
//Explanation
//Above the matrix of size 3x4 looks like
//1 1 0 1
//1 0 0 1
//1 1 0 1
//The two unique rows are 1 1 0 1 and 1 0 0 1 .

package Medium;

public class PrintUniqueRowsInBinaryMatrix {

	static class Trie
    {
    	boolean isLeaf;	// set when node is a leaf node
    	Trie[] character = new Trie[2];
    
    	// Constructor
    	Trie()
    	{
    		isLeaf = false;
    	}
    };
    
    public static void printMat(int a[][],int r, int c)
    {
        Trie head = new Trie();
        
        for (int i = 0; i < r; i++)
        {
            if(insert(head, a[i]))
            {
                for (int j = 0; j < c; j++)
                {
                    System.out.print(a[i][j] + " ");
                }
                
                System.out.print("$");
            }
        }
    }
    
    private static boolean insert(Trie head, int[] A)
    {
        // start from root node
		Trie curr = head;

		for(int i = 0; i < A.length; i++)
		{
			// create a new node if path doesn't exists
			if (curr.character[A[i]] == null) {
				curr.character[A[i]] = new Trie();
			}

			// go to next node
			curr = curr.character[A[i]];
		}

		// if row is inserted before, return false
		if (curr.isLeaf) {
			return false;
		}

		// mark leaf node and return true
		return (curr.isLeaf = true);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
