//Given an array of N elements, you are required to find the maximum sum of lengths of all non-overlapping subarrays with K as the maximum element in the subarray.
//Example:
//Input:
//3
//9 
//2 1 4 9 2 3 8 3 4
//4
//7
//1 2 3 2 3 4 1
//4
//10
//4 5 7 1 2 9 8 4 3 1
//4
//Output:
//5
//7
//4
//Explanation:
//Test Case 1: 
//{2, 1, 4} => Length = 3 
//{3, 4} => Length = 2 
//So, 3 + 2 = 5 is the answer
//Test Case 2: {1, 2, 3, 2, 3, 4, 1} => Length = 7
//Test Case 3:
//{4} => Length = 1 
//{4, 3, 1} => Length = 3 
//So, 1 + 3 = 4 is the answer.

package Medium;

public class SumOfLengthsOfMaxSubarray {
	
	// Returns max sum of lengths with maximum element as k 
    static int calculateMaxSumLength(int arr[], int n, int k) 
    { 
        int ans = 0; // final sum of lengths 
  
        // number of elements in current subarray 
        int count = 0; 
  
        // variable for checking if k appeared in subarray 
        int flag = 0; 
  
        for (int i = 0; i < n;) 
        { 
            count = 0; 
            flag = 0; 
  
            // count the number of elements which are less than equal to k 
            while (i < n && arr[i] <= k) 
            { 
                count++; 
                if (arr[i] == k) 
                    flag = 1; 
                i++; 
            } 
  
            // if current element appeared in current subarray add count to sumLength 
            if (flag == 1) 
                ans += count; 
  
            // skip the array elements which are greater than k 
            while (i < n && arr[i] > k) 
                i++; 
        } 
        return ans; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
