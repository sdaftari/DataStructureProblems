//Given an array of positive integers. Check whether there are two numbers present with given product.
//Example:
//Input:
//2
//5 25
//1 2 3 4 5
//8 63
//5 7 9 22 15 344 92 8
//
//Output:
//No
//Yes

package Easy;
import java.util.*;

public class EqualToProduct {

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3, 4, 5};
		int k = 25;
		boolean found = false;
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		for (int j = 0; j < arr.length; j++) 
		{
			if (arr[j] != 0 && k % arr[j] == 0 && map.containsKey(k / arr[j]) == false) 
				map.put(arr[j], true);			
			else if (arr[j] != 0 && k % arr[j] == 0 && map.containsKey(k / arr[j]) == true) 
			{
				found = true;
				System.out.println("Yes");
				break;
			}
		}
		if (found == false) 
			System.out.println("No");
	}

}
