//Monu lives in a society which is having high rise buildings. This is the time of sunrise and monu wants see the buildings receiving the sunlight. Help him in counting the number of buildings recieving the sunlight.
//Given an array H representing heights of buildings. You have to count the buildings which will see the sunrise (Assume : Sun rise on the side of array starting point).
//Input : arr[] = {7, 4, 8, 2, 9}
//Output: 3
//Explanation: As 7 is the first element, it can 
//see the sunset.
//4 can't see the sunset as 7 is hiding it. 
//8 can see.
//2 can't see the sunset.
//9 also can see the sunset.
//
//Input : arr[] = {2, 3, 4, 5}
//Output : 4
//
//Time Complexity : O(n)
//Auxiliary Space : O(1)

package Medium;

public class FacingSun {
	
	// Returns count buildings that can see sunlight 
    static int countBuildings(int arr[], int n) 
    { 
        // Initialize result  (Note that first building 
        // always sees sunlight) 
        int count = 1; 
       
        // Start traversing element 
        int curr_max = arr[0]; 
        for (int i=1; i<n; i++) 
        { 
            // If curr_element is maximum, 
            // update maximum and increment count 
            if (arr[i] > curr_max) 
            { 
                count++; 
                curr_max=arr[i]; 
            } 
        } 
       
        return count; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
