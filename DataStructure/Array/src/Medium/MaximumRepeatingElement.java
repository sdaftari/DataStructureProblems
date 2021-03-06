//Given an array A of size N, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= N. Find the maximum repeating number in this array. 
//If there are two or more maximum repeating numbers print the element having least value.
//Example:
//Input:
//
//2
//4 3
//2 2 1 2
//6 3
//2 2 1 0 0 1
//Output:
//2
//0
//
//Explanation:
//
//Testcase1: 2 is the most frequent element.
//Testcase2: 0 1 and 2 all have same frequency of 2. But since 0 is smallest, we print that.

package Medium;
import java.util.*;
import java.util.Map.Entry;

public class MaximumRepeatingElement {
	static int mostFrequent(int arr[], int n) 
    {           
        // Insert all elements in hash 
        Map<Integer, Integer> hp = new HashMap<Integer, Integer>(); 
          
        for(int i = 0; i < n; i++) 
        { 
            int key = arr[i]; 
            if(hp.containsKey(key)) 
            { 
                int freq = hp.get(key); 
                freq++; 
                hp.put(key, freq); 
            } 
            else
            { 
                hp.put(key, 1); 
            } 
        } 
          
        // find max frequency. 
        int max_count = 0, res = -1; 
          
        for(Entry<Integer, Integer> val : hp.entrySet()) 
        { 
            if (max_count < val.getValue()) 
            { 
                res = val.getKey(); 
                max_count = val.getValue(); 
            } 
        } 
          
        return res; 
    } 
      
    // Driver code 
    public static void main (String[] args) { 
          
        int arr[] = {2, 2, 1, 0, 0, 1}; 
        int n = arr.length; 
          
        System.out.println(mostFrequent(arr, n)); 
    } 

}
