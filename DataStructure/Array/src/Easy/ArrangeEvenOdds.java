//Given an array. The task is to arrange the array such that odd elements occupy the odd positions and even elements occupy the even positions. The order of elements must remain same. Consider zero-based indexing. 
//After printing according to conditions, if remaining, print the remaining elements as it is.
//Example:
//Input:
//2
//6
//1 2 3 4 5 6
//4
//3 2 4 1
//Output:
//2 1 4 3 6 5
//2 3 4 1
//Time Complexity: O(n).
//Auxiliary Space: O(1).

package Easy;

public class ArrangeEvenOdds {
	// function to arrange 
	// odd and even numbers 
	public static void arrangeOddAndEven(int arr[], int n) 
	{ 
	    int oddInd = 1; 
	    int evenInd = 0; 
	    while (true) 
	    { 
	        while (evenInd < n && arr[evenInd] % 2 == 0) 
	            evenInd += 2; 
	              
	        while (oddInd < n && arr[oddInd] % 2 == 1) 
	            oddInd += 2; 
	              
	        if (evenInd < n && oddInd < n) 
	            { 
	                int temp = arr[evenInd]; 
	                arr[evenInd] = arr[oddInd]; 
	                arr[oddInd] = temp; 
	            } 
	              
	        else
	            break; 
	    } 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
