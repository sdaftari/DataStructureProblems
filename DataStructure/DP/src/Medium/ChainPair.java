//You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. 
//Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given 
//set of pairs. 
//Input
//2
//5
//5  24 39 60 15 28 27 40 50 90
//2
//5 10 1 11 
//
//Output
//3
//1
//Explanation
//(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
//(ii) The max length chain possible is only of length one.

package Medium;

public class ChainPair {

	int a; 
    int b; 
      
    public ChainPair(int a, int b) { 
        this.a = a; 
        this.b = b; 
    } 
      
    // This function assumes that arr[] is sorted in increasing order 
    // according the first (or smaller) values in pairs. 
    static int maxChainLength(ChainPair arr[], int n) 
    { 
       int i, j, max = 0; 
       int mcl[] = new int[n]; 
       
       /* Initialize MCL (max chain length) values for all indexes */
       for ( i = 0; i < n; i++ ) 
          mcl[i] = 1; 
       
       /* Compute optimized chain length values in bottom up manner */
       for ( i = 1; i < n; i++ ) 
          for ( j = 0; j < i; j++ ) 
             if ( arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1) 
                mcl[i] = mcl[j] + 1; 
       
       // mcl[i] now stores the maximum chain length ending with pair i 
       
       /* Pick maximum of all MCL values */
       for ( i = 0; i < n; i++ ) 
          if ( max < mcl[i] ) 
             max = mcl[i]; 
       
       return max; 
    } 
  
    /* Driver program to test above function */
    public static void main(String[] args)  
    { 
    	ChainPair arr[] = new ChainPair[] {new ChainPair(5,24), new ChainPair(15, 25), 
                                  new ChainPair (27, 40), new ChainPair(50, 60)}; 
        System.out.println("Length of maximum size chain is " +  
                                  maxChainLength(arr, arr.length)); 
    } 
}
