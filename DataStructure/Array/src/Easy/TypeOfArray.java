//You are given an array of size N having no duplicate elements. The array can be categorized into following:
//1.  Ascending
//2.  Descending
//3.  Descending Rotated
//4.  Ascending Rotated
//Your task is to print which type of array it is and the maximum element of that array.
//Example:
//Input:
//2
//5
//2 1 5 4 3
//5
//3 4 5 1 2
//
//Output:
//5 3
//5 4
//
//Explanation:
//Testcase1:
//Input : A[] = { 2, 1, 5, 4, 3}
//Output : Descending rotated with maximum element 5 
//Testcase2:
//Input : A[] = { 3, 4, 5, 1, 2}
//Output : Ascending rotated with maximum element 5

package Easy;

public class TypeOfArray {
	public static int max(int a, int b) 
    { 
        return (a > b)? a : b; 
    } 
  
    // Function to find the type of an array 
    // and maximum element in it 
    public static void findType(int arr[]) 
    { 
        int i = 0; 
        int n = arr.length; 
  
        // Check if the array is in ascending order 
        while (i < n-1 && arr[i] <= arr[i+1]) 
            i++; 
  
        // If i reaches to last index that means 
        // all elements are in increasing order 
        if (i == n-1) 
        { 
            System.out.println("Ascending with maximum element = " + 
                               arr[n-1]); 
            return ; 
        } 
  
        // If first element is greater than next one 
        if (i == 0) 
        { 
            while (i < n-1 && arr[i] >= arr[i+1]) 
                i++; 
  
            // If i reaches to last index 
            if (i == n - 1) 
            { 
                System.out.println("Descending with maximum " + 
                                   "element =  " + arr[0]); 
                return ; 
            } 
  
            // If the whole array is not in decreasing order 
            // that means it is first decreasing then 
            // increasing, i.e., descending rotated, so 
            // its maximum element will be the point breaking 
            // the order i.e. i so, max will be i+1 
            if (arr[0] < arr[i+1]) 
            { 
                System.out.println("Descending rotated with" + 
                " maximum element = " + max(arr[0], arr[i+1])); 
                return ; 
            } 
            else
            { 
                System.out.println("Ascending rotated with" + 
                    " maximum element = " + max(arr[0], arr[i+1])); 
                return ; 
            } 
        } 
  
        // If whole array is not increasing that means at some 
        // point it is decreasing, which makes it ascending rotated 
        // with max element as the decreasing point 
        if (i < n-1 && arr[0] > arr[i+1]) 
        { 
  
            System.out.println("Ascending rotated with maximum" + 
                            " element =  " + max(arr[i], arr[0])); 
            return; 
        } 
  
        System.out.println("Descending rotated with maximum " + 
                               "element " + max(arr[i],arr[0])); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
