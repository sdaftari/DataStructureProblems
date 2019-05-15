//Given an array of positive integers of size N, we can form a group of two or three only, the group should be such that the sum of all elements in that group is a multiple of 3. 
//Count all possible number of groups that can be generated in this way.
//Example:
//Input:
//2
//5
//3 6 7 2 9
//4
//2 1 3 4
//
//Output:
//8
//4
//
//Explanation:
//Testcase 1: 
//Groups of two are: {3,6}, {3,9}, {9,6}, {7,2}, {3, 6,9}, 
//Groups of three are: {3, 7, 2}, {7, 2, 6}, {7, 2, 9}.
//Time Complexity: O(n)
//Auxiliary Space: O(1)

package Extra;

public class GroupsOfMultipleOfThree {
	
	// Returns count of all possible groups that can be formed from elements 
    // of a[]. 
  
    int findgroups(int arr[], int n)  
    { 
        // Create an array C[3] to store counts of elements with remainder 
        // 0, 1 and 2.  c[i] would store count of elements with remainder i 
        int c[] = new int[]{0, 0, 0}; 
        int i; 
  
        int res = 0; // To store the result 
  
        // Count elements with remainder 0, 1 and 2 
        for (i = 0; i < n; i++) 
            c[arr[i] % 3]++; 
  
        // Case 3.a: Count groups of size 2 from 0 remainder elements 
        res += ((c[0] * (c[0] - 1)) >> 1); 
  
        // Case 3.b: Count groups of size 2 with one element with 1 
        // remainder and other with 2 remainder 
        res += c[1] * c[2]; 
  
        // Case 4.a: Count groups of size 3 with all 0 remainder elements 
        res += (c[0] * (c[0] - 1) * (c[0] - 2)) / 6; 
  
        // Case 4.b: Count groups of size 3 with all 1 remainder elements 
        res += (c[1] * (c[1] - 1) * (c[1] - 2)) / 6; 
  
        // Case 4.c: Count groups of size 3 with all 2 remainder elements 
        res += ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6); 
  
        // Case 4.c: Count groups of size 3 with different remainders 
        res += c[0] * c[1] * c[2]; 
  
        // Return total count stored in res 
        return res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
