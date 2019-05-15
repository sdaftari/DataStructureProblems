//Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//4
//1 6 5 11
//4
//36 7 46 40
//
//Output : 
//1
//23
//
//Explaination :
//Subset1 = {1, 5, 6}, sum of Subset1 = 12
//Subset2 = {11},       sum of Subset2 = 11

package Medium;

public class MinimumSumPartition {
	// Function to find the minimum sum 
    public static int findMinRec(int arr[], int i, int sumCalculated, int sumTotal) 
    { 
        // If we have reached last element. 
        // Sum of one subset is sumCalculated, 
        // sum of other subset is sumTotal- 
        // sumCalculated.  Return absolute  
        // difference of two sums. 
        if (i == 0) 
            return Math.abs((sumTotal-sumCalculated) - sumCalculated); 
       
       
        // For every item arr[i], we have two choices 
        // (1) We do not include it first set 
        // (2) We include it in first set 
        // We return minimum of two choices 
        return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i-1], sumTotal), findMinRec(arr, i-1, sumCalculated, sumTotal)); 
    } 
       
    // Returns minimum possible difference between 
    // sums of two subsets 
    public static int findMin(int arr[], int n) 
    { 
        // Compute total sum of elements 
        int sumTotal = 0; 
        for (int i = 0; i < n; i++) 
            sumTotal += arr[i]; 
       
        // Compute result using recursive function 
        return findMinRec(arr, n, 0, sumTotal); 
    }

	public static void main(String[] args) {
		int[] arr = {36, 7, 46, 40};
		MinimumSumPartition obj = new MinimumSumPartition();
		System.out.println(obj.findMin(arr, 4));
	}

}
