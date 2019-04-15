package Easy;

public class ValueEqualToIndex {
	
	// Unsorted array
	static int linearSearch(int arr[], int n) 
    { 
        int i; 
        for(i = 0; i < n; i++) 
        { 
            if(arr[i] == i) 
                return i; 
        } 
        
        /* If no fixed point present  
           then return -1 */
        return -1; 
    } 
	
	// Sorted array
	static int binarySearch(int arr[], int low, int high) 
    { 
        if(high >= low) 
        {    
            /* low + (high - low)/2; */
            int mid = (low + high)/2;   
            if(mid == arr[mid]) 
                return mid; 
            if(mid > arr[mid]) 
                return binarySearch(arr, (mid + 1), high); 
            else
                return binarySearch(arr, low, (mid -1)); 
        } 
        
        /* Return -1 if there is  
           no Fixed Point */
        return -1; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
