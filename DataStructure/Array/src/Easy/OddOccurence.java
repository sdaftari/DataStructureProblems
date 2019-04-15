//Given an array of positive integers where all numbers occur even number of times except one number which occurs odd number of times. Find the number.
//Examples :
//
//Input : arr = {1, 2, 3, 2, 3, 1, 3}
//Output : 3
//
//Input : arr = {5, 7, 2, 7, 5, 2, 5}
//Output : 5
//Time Complexity: O(n)

package Easy;

public class OddOccurence {

	int getOddOccurrence(int ar[], int ar_size)  
    { 
        int i; 
        int res = 0; 
        for (i = 0; i < ar_size; i++)  
        { 
            res = res ^ ar[i]; 
        } 
        return res; 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
