//Minimum insertions to form a palindrome. Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
//The problem of finding minimum insertions can also be solved using Longest Common Subsequence (LCS) Problem. 
//If we find out LCS of string and its reverse, we know how many maximum characters can form a palindrome. We need insert remaining characters. Following are the steps.
//1) Find the length of LCS of input string and its reverse. Let the length be ‘l’.
//2) The minimum number insertions needed is length of input string minus ‘l’.
//
//Time: O(n^2). Space: O(n^2)

package Medium;

public class FormPalindrome {
	
	// LCS based function to find minimum number 
    // of insersions 
    static int findMinInsertionsLCS(String str, int n) 
    { 
        // Using StringBuffer to reverse a String 
        StringBuffer sb = new StringBuffer(str); 
        sb.reverse(); 
        String revString = sb.toString(); 
  
        // The output is length of string minus 
        // length of lcs of str and it reverse 
        return (n - lcs(str, revString , n, n)); 
    } 
    
    /* Returns length of LCS for X[0..m-1], 
    Y[0..n-1]. See http://goo.gl/bHQVP for 
    details of this function */
	 static int lcs( String X, String Y, int m, int n ) 
	 { 
	     int L[][] = new int[n+1][n+1]; 
	     int i, j; 
	
	     /* Following steps build L[m+1][n+1] in 
	        bottom up fashion. Note that L[i][j] 
	        contains length of LCS of X[0..i-1] 
	        and Y[0..j-1] */
	     for (i=0; i<=m; i++) 
	     { 
	         for (j=0; j<=n; j++) 
	         { 
	             if (i == 0 || j == 0) 
	                 L[i][j] = 0; 
	
	             else if (X.charAt(i-1) == Y.charAt(j-1)) 
	                 L[i][j] = L[i-1][j-1] + 1; 
	
	             else
	                 L[i][j] = Integer.max(L[i-1][j], L[i][j-1]); 
	         } 
	     } 

        /* L[m][n] contains length of LCS for 
        X[0..n-1] and Y[0..m-1] */
	     return L[m][n]; 
	 } 

	public static void main(String[] args) {
		System.out.println(findMinInsertionsLCS("abc", 3));

	}

}
