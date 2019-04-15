//Given an array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.

package Easy;

public class SingleElement {
	// Return the maximum Sum of difference 
    // between consecutive elements. 
    static int findSingle(int ar[], int ar_size) 
    { 
        // Do XOR of all elements and return 
        int res = ar[0]; 
        for (int i = 1; i < ar_size; i++) 
            res = res ^ ar[i]; 
      
        return res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
