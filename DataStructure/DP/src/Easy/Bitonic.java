// if it is first increasing, then decreasing
// Complexity O(n)

package Easy;

public class Bitonic {

	public static void main(String[] args) {
		//int arr[] = {12, 4, 78, 90, 45, 23};
		int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int n = arr.length;
//        System.out.println("Max length Bitnoic Subarray is "
//                            + bitonic(arr, n));
        System.out.println(findMaximum(arr, 0, n-1));
	}
	
	public static int bitonic(int[] arr, int size)
	{
		int[] inc = new int[size];
		int[] dec = new int[size];
		int max;
		inc[0] = 1;
		dec[size-1] = 1;
		
		// Create array to count number of increasing elements
		for(int i = 1; i < size; i++)
			inc[i] = arr[i-1] <= arr[i] ? inc[i-1] + 1 : 1;
		
		// Create array to count number of decreasing elements
		for(int i = size-2; i >= 0; i--)
			dec[i] = arr[i] >= arr[i+1] ? dec[i+1] + 1 : 1;
			
		// Bitonic sequence length is max of sum -1, as ith element is counted twice
		// Find max of that
		max = Math.max(inc[0], dec[0]) - 1;
		
		for(int i = 1; i < size; i++)
		{
			if(max < inc[i] + dec[i] - 1)
				max = inc[i] + dec[i] - 1;
		}
		
		return max;
	}
	
	// To find maximum element in bitonic array
	// function to find the  
    // maximum element 
    static int findMaximum(int arr[], int low, int high) 
    { 
       
       /* Base Case: Only one element is  
          present in arr[low..high]*/
       if (low == high) 
         return arr[low]; 
       
       /* If there are two elements and  
          first is greater then the first  
          element is maximum */
       if ((high == low + 1) && arr[low] >= arr[high]) 
          return arr[low]; 
       
       /* If there are two elements and  
          second is greater then the second  
          element is maximum */
       if ((high == low + 1) && arr[low] < arr[high]) 
          return arr[high]; 
          
       /*low + (high - low)/2;*/
       int mid = (low + high)/2;    
       
       /* If we reach a point where arr[mid]  
          is greater than both of its adjacent  
          elements arr[mid-1] and arr[mid+1],  
          then arr[mid] is the maximum element*/
       if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) 
          return arr[mid]; 
       
       /* If arr[mid] is greater than the next  
          element and smaller than the previous  
          element then maximum lies on left side  
          of mid */
       if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) 
         return findMaximum(arr, low, mid-1); 
       else 
         return findMaximum(arr, mid + 1, high); 
    } 
}
