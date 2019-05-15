//Given a permutation of first n natural numbers as array and an integer k. Print the lexicographically largest permutation after at most k swaps
//Examples:
//Input: arr[] = {4, 5, 2, 1, 3}
//       k = 3
//Output: 5 4 3 2 1
//Explanation:
//Swap 1st and 2nd elements: 5 4 2 1 3 
//Swap 3rd and 5th elements: 5 4 3 1 2 
//Swap 4th and 5th elements: 5 4 3 2 1 
//
//Input: arr[] = {2, 1, 3}
//       k = 1
//Output: 3 1 2

package Extra;

public class LargestPermutationAfterKSwaps {
	// Function to calculate largest permutation after K swaps 
    void KswapPermutation(int arr[], int n, int k) 
    { 
        // Auxiliary dictionary of storing the index of elements 
        int pos[] = new int[n+1]; 
      
        for (int i = 0; i < n; i++) 
            pos[arr[i]] = i; 
      
        for (int i = 0; i < n && k > 0; i++) 
        {  
            // If element is already i'th largest, then no need to swap 
            if (arr[i] == n-i) 
                continue; 
      
            // Find position of i'th largest value, n-i 
            int temp = pos[n-i]; 
      
            // Swap the elements position 
            pos[arr[i]] = pos[n-i]; 
            pos[n-i] = i; 
      
            // Swap the ith largest value with the current value at ith place 
            int tmp1 = arr[temp]; 
            arr[temp] = arr[i]; 
            arr[i] = tmp1; 
      
            // decrement number of swaps 
            --k; 
        } 
    } 

	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 1, 3};
		LargestPermutationAfterKSwaps obj = new LargestPermutationAfterKSwaps();
		obj.KswapPermutation(arr, arr.length, 3);
	}

}
