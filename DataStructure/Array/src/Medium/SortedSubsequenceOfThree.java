///Given an array A of N integers, Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector, 
//if no such element is present then return the empty vector of size 0.
//Example:
//Input:
//2
//5
//1 2 1 1 3
//3
//1 1 3
//Output:
//1
//0
//
//Explanation:
//There are 2 test cases
//For first test case
//a sub-sequence 1 2 3 exist 
//For second test case
//no such sub-sequence exist
			
package Medium;

public class SortedSubsequenceOfThree {

	// A function to find a sorted subsequence of size 3 
    static void find3Numbers(int arr[]) 
    { 
        int n = arr.length; 
        int max = n-1; //Index of maximum element from right side 
        int min = 0; //Index of minimum element from left side 
        int i; 
  
        // Create an array that will store index of a smaller 
        // element on left side. If there is no smaller element 
        // on left side, then smaller[i] will be -1. 
        int[] smaller = new int[n]; 
        smaller[0] = -1;  // first entry will always be -1 
        for (i = 1; i < n; i++) 
        { 
            if (arr[i] <= arr[min]) 
            { 
                min = i; 
                smaller[i] = -1; 
            } 
            else
                smaller[i] = min; 
        } 
  
        // Create another array that will store index of a 
        // greater element on right side. If there is no greater 
        // element on right side, then greater[i] will be -1. 
        int[] greater = new int[n]; 
        greater[n-1] = -1;  // last entry will always be -1 
        for (i = n-2; i >= 0; i--) 
        { 
            if (arr[i] >= arr[max]) 
            { 
                max = i; 
                greater[i] = -1; 
            } 
            else
                greater[i] = max; 
        } 
  
        // Now find a number which has both a greater number 
        // on right side and smaller number on left side 
        for (i = 0; i < n; i++) 
        { 
            if (smaller[i] != -1 && greater[i] != -1) 
            { 
                System.out.print(arr[smaller[i]]+" "+ 
                                 arr[i]+" "+ arr[greater[i]]); 
                return; 
            } 
        } 
  
        // If we reach number, then there are no such 3 numbers 
        System.out.println("No such triplet found"); 
        return; 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
