//Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.
//Example:
//
//Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
//       A2[] = {2, 1, 8, 3}
//Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
//Let size of A1[] be m and size of A2[] be n.
//1) Create a temporary array temp of size m and copy contents of A1[] to it.
//2) Create another array visited[] and initialize all entries in it as false. visited[] is used to mark those elements in temp[] which are copied to A1[].
//3) Sort temp[]
//4) Initialize the output index ind as 0.
//5) Do following for every element of A2[i] in A2[]
//�..a) Binary search for all occurrences of A2[i] in temp[], if present then copy all occurrences to A1[ind] and increment ind. Also mark the copied elements visited[]
//6) Copy all unvisited elements from temp[] to A1[].
//
//Time complexity: The steps 1 and 2 require O(m) time. Step 3 requires O(mLogm) time. Step 5 requires O(nLogm) time. Therefore overall time complexity is O(mLogm + nLogm).

package Medium;
import java.util.*;

public class RelativeOrder {
	
	// Sort A1[0..m-1] according to the order 
    // defined by A2[0..n-1]. 
    static void sortAccording(int A1[], int A2[], int m,  
                                                 int n) 
    { 
        // The temp array is used to store a copy  
        // of A1[] and visited[] is used to mark the  
        // visited elements in temp[]. 
        int temp[] = new int[m], visited[] = new int[m]; 
        for (int i = 0; i < m; i++) 
        { 
            temp[i] = A1[i]; 
            visited[i] = 0; 
        } 
       
        // Sort elements in temp 
        Arrays.sort(temp); 
          
        // for index of output which is sorted A1[] 
        int ind = 0;   
       
        // Consider all elements of A2[], find them 
        // in temp[] and copy to A1[] in order. 
        for (int i = 0; i < n; i++) 
        { 
            // Find index of the first occurrence 
            // of A2[i] in temp 
            int f = first(temp, 0, m-1, A2[i], m); 
       
            // If not present, no need to proceed 
            if (f == -1) continue; 
       
            // Copy all occurrences of A2[i] to A1[] 
            for (int j = f; (j < m && temp[j] == A2[i]); 
                                                  j++) 
            { 
                A1[ind++] = temp[j]; 
                visited[j] = 1; 
            } 
        } 
       
        // Now copy all items of temp[] which are  
        // not present in A2[] 
        for (int i = 0; i < m; i++) 
            if (visited[i] == 0) 
                A1[ind++] = temp[i]; 
    } 
    
    /* A Binary Search based function to find 
    index of FIRST occurrence of x in arr[]. 
    If x is not present, then it returns -1 */
    static int first(int arr[], int low, int high, 
                    int x, int n) 
    { 
        if (high >= low) 
        {    
            /* (low + high)/2; */
            int mid = low + (high-low)/2; 
              
            if ((mid == 0 || x > arr[mid-1]) && 
                                arr[mid] == x) 
                return mid; 
            if (x > arr[mid]) 
                return first(arr, (mid + 1), high, 
                                            x, n); 
            return first(arr, low, (mid -1), x, n); 
        } 
        return -1; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
