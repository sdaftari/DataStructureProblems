//Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
//Examples:
//
//Input :  {0, 1, 2, 0, 1, 2}
//Output : {0, 0, 1, 1, 2, 2}
//
//Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
//Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
//Time Complexity: O(n)

package Easy;

public class SortArrayOf012 {
	
	// Sort the input array, the array is assumed to 
    // have values in {0, 1, 2} 
    static void sort012(int a[], int arr_size) 
    { 
        int lo = 0; 
        int hi = arr_size - 1; 
        int mid = 0,temp=0; 
        while (mid <= hi) 
        { 
            switch (a[mid]) 
            { 
            case 0: 
            { 
                temp   =  a[lo]; 
                a[lo]  = a[mid]; 
                a[mid] = temp; 
                lo++; 
                mid++; 
                break; 
            } 
            case 1: 
                mid++; 
                break; 
            case 2: 
            { 
                temp = a[mid]; 
                a[mid] = a[hi]; 
                a[hi] = temp; 
                hi--; 
                break; 
            } 
            } 
        } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
