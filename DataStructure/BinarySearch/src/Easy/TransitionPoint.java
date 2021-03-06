//You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. Transition point is a point where "0" ends and "1" begins.
//Example:
//
//Input
//1
//5
//0 0 0 1 1
//
//Output
//3
// Time: O(log n)

package Easy;

public class TransitionPoint {
	int transitionPoint(int arr[],int n)
	{
        // Initialise lower and upper bounnds 
        int lb = 0, ub = n-1; 
       
        // Perform Binary search 
        while (lb <= ub) 
        { 
            // Find mid 
            int mid = (lb+ub)/2; 
       
            // update lower_bound if mid contains 0 
            if (arr[mid] == 0) 
                lb = mid+1; 
       
            // If mid contains 1 
            else if (arr[mid] == 1) 
            { 
                // Check if it is the left most 1 
                // Return mid, if yes 
                if (arr[mid-1]==0) 
                    return mid; 
       
                // Else update upper_bound 
                ub = mid-1; 
            } 
        } 
        return -1; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
