//Given an array of distinct integers, print all the pairs having positive value and negative value of a number that exists in the array.
//NOTE: If there is no such pair in the array , print "0".
//Example:
//Input:
//2
//6
//1 -3 2 3 6 -1
//8
//4 8 9 -4 1 -1 -8 -9
//
//Output:
//-1 1 -3 3 
//-1 1 -4 4 -8 8 -9 9 

package Easy;
import java.util.*;

public class PairsWithPositiveAndNegative {
	
	// Print pair with negative  
	// and positive value  
	static void printPairs(int arr[], int n)  
	{  
	    ArrayList<Integer> v = new ArrayList<Integer> ();  
	    HashMap<Integer, Integer> cnt = new HashMap<>();  
	  
	    // For each element of array.  
	    for (int i = 0; i < n; i++)  
	    {  
	        // If element has not encounter early,  
	        // mark it on cnt array.  
	        if (cnt.containsKey(Math.abs(arr[i])))  
	            cnt.put(Math.abs(arr[i]), 1);  
	  
	        // If seen before, push it in vector  
	        // (given that elements are distinct)  
	        else 
	        {  
	            v.add(Math.abs(arr[i]));  
	            cnt.put(Math.abs(arr[i]), 0);  
	        }  
	    }  
	  
	    if (v.size() == 0)  
	        return;  
	  
	    Collections.sort(v);  
	    for (int i = 0; i < v.size(); i++)  
	        System.out.print("-" + v.get(i) +  " " + v.get(i) + " ");  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
