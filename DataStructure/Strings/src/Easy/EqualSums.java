//Given an array A of distinct integers. The task is to find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and elements of array are distinct.
//Example:
//Input:
//7
//3 4 7 1 2 9 8
//Output:
//1
//Explanation:
//Testcase 1: (3, 7) and (9, 1) are the pairs whose sum are equal.

package Easy;
import java.util.*;

public class EqualSums {
	
	public static boolean isEqual(int arr[],int n)
    {
        if(n<4)
        return false;
        List<Integer> hash=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        for(int j=i+1;j<n;++j)
        {
            int sum=arr[i]+arr[j];
            if(hash.contains(sum))
            return true;
            hash.add(sum);
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
