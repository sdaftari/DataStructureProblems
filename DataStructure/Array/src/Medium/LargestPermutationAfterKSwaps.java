package Medium;

public class LargestPermutationAfterKSwaps {
	// Function to calculate largest permutation after K swaps 
    static void KswapPermutation(int arr[], int n, int k) 
    { 
          
        // Auxiliary dictionary of storing the position 
        // of elements 
        int pos[] = new int[n+1]; 
      
        for (int i = 0; i < n; ++i) 
            pos[arr[i]] = i; 
      
        for (int i = 0; i < n && k > 0; ++i) 
        { 
              
            // If element is already i'th largest, 
            // then no need to swap 
            if (arr[i] == n-i) 
                continue; 
      
            // Find position of i'th largest value, n-i 
            int temp = pos[n-i]; 
      
            // Swap the elements position 
            pos[arr[i]] = pos[n-i]; 
            pos[n-i] = i; 
      
            // Swap the ith largest value with the 
            // current value at ith place 
            int tmp1 = arr[temp]; 
            arr[temp] = arr[i]; 
            arr[i] = tmp1; 
      
            // decrement number of swaps 
            --k; 
        } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
