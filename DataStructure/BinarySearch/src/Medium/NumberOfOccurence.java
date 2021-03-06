//Given a sorted array A of size N and a number X, you need to find the number of occurrences of X in A.
//Example:
//Input:
//2
//7 2
//1 1 2 2 2 2 3
//7 4
//1 1 2 2 2 2 3
//Output:
//4
//-1
//
//Explanation:
//Testcase 1: 2 occurs 4 times in 1 1 2 2 2 2 3
//Testcase 2: 4 is not present in 1 1 2 2 2 2 3
//Time Complexity: O(Logn)

package Medium;

public class NumberOfOccurence {
	
	/* if x is present in arr[] then returns  
    the count of occurrences of x,  
    otherwise returns -1. */
 static int count(int arr[], int x, int n) 
 { 
   // index of first occurrence of x in arr[0..n-1]     
   int i;  
     
   // index of last occurrence of x in arr[0..n-1] 
   int j;  
        
   /* get the index of first occurrence of x */
   i = first(arr, 0, n-1, x, n); 
    
   /* If x doesn't exist in arr[] then return -1 */
   if(i == -1) 
     return i; 
       
   /* Else get the index of last occurrence of x.  
      Note that we are only looking in the  
      subarray after first occurrence */  
   j = last(arr, i, n-1, x, n);      
       
   /* return count */
   return j-i+1; 
 } 
    
 /* if x is present in arr[] then returns the  
    index of FIRST occurrence of x in arr[0..n-1],  
    otherwise returns -1 */
 static int first(int arr[], int low, int high, int x, int n) 
 { 
   if(high >= low) 
   { 
     /*low + (high - low)/2;*/  
     int mid = (low + high)/2;   
     if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
       return mid; 
     else if(x > arr[mid]) 
       return first(arr, (mid + 1), high, x, n); 
     else
       return first(arr, low, (mid -1), x, n); 
   } 
   return -1; 
 } 
    
 /* if x is present in arr[] then returns the  
    index of LAST occurrence of x in arr[0..n-1],  
    otherwise returns -1 */
 static int last(int arr[], int low, int high, int x, int n) 
 { 
   if(high >= low) 
   { 
     /*low + (high - low)/2;*/      
     int mid = (low + high)/2;  
     if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x ) 
       return mid; 
     else if(x < arr[mid]) 
       return last(arr, low, (mid -1), x, n); 
     else
       return last(arr, (mid + 1), high, x, n);       
   } 
   return -1; 
 } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
