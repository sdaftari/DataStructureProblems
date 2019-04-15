//Given an array of integers, we need to get total XOR of all subarray XORs where subarray XOR can be obtained by XORing all elements of it.
//
//Examples :
//
//Input : arr[] = [3, 5, 2, 4, 6]
//Output : 7
//Total XOR of all subarray XORs is,
//(3) ^ (5) ^ (2) ^ (4) ^ (6)
//(3^5) ^ (5^2) ^ (2^4) ^ (4^6)
//(3^5^2) ^ (5^2^4) ^ (2^4^6)
//(3^5^2^4) ^ (5^2^4^6) ^
//(3^5^2^4^6) = 7     
//
//Input : arr[] = {1, 2, 3}
//Output : 2
//
//Input : arr[] = {1, 2, 3, 4}
//Output : 0
//So we can iterate over all elements once and calculate their frequencies and if it is odd then we can include that in our final result by XORing it with the result.
//Total time complexity  O(N)

package Medium;

public class XOROfSubarrays {
	
	// Returns XOR of all subarray 
    // xors 
    static int getTotalXorOfSubarrayXors( 
                          int arr[], int N) 
    { 
          
        // initialize result by 0  
        // as (a XOR 0 = a) 
        int res = 0; 
      
        // loop over all elements once 
        for (int i = 0; i < N; i++) 
        { 
            // get the frequency of 
            // current element 
            int freq = (i + 1) * (N - i); 
      
            // Uncomment below line to print  
            // the frequency of arr[i] 
              
            // if frequency is odd, then  
            // include it in the result 
            if (freq % 2 == 1) 
                res = res ^ arr[i]; 
        } 
      
        // return the result 
        return res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
