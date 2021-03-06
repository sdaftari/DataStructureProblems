package Medium;

public class KthElementInSpiralMatrix {
	
	int findK(int A[][], int m, int n, int k) 
	{ 
	    if (m < 1 || n < 1) 
	        return -1; 
	  
	    /*..........If element is in outermost ring .......*/
	    /* Element is in first row */
	    if (k <= n) 
	        return A[0][k-1]; 
	  
	    /* Element is in last column */
	    // n is #elements in first row + m-1 elements in last col
	    if (k <= (n + m-1)) 
	        return A[(k-n)][n-1]; 
	  
	    /* Element is in last row */
	    if (k <= (n+m-1+n-1)) 
	        return A[m-1][n-1-(k-(n+m-1))]; 
	  
	    /* Element is in first column */
	    if (k <= (n+m-1+n-1+m-2)) 
	        return A[m-1-(k-(n+m-1+n-1))][0]; 
	  
	    /*..........If element is NOT in outermost ring .......*/
	    /* Recursion for sub-matrix. &A[1][1] is 
	       address to next inside sub matrix.*/
	    return findK(A, m-2, n-2, k-(2*m+2*n-4)); 
	} 

	public static void main(String[] args) {
		int[][] a = {{1, 2, 3, 4, 5, 6}, 
                {7, 8, 9, 10, 11, 12}, 
                {13, 14, 15, 16, 17, 18}}; 
		int k = 17; 
		KthElementInSpiralMatrix obj = new KthElementInSpiralMatrix();
		System.out.println(obj.findK(a, 3, 6, k));
	}

}
