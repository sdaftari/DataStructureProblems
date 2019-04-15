//Given two sorted arrays A and B. The task is to complete the function max_path_sum that takes 4 argument, the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote 
//the size of array A and B respectively. The function returns the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays .
//Example:
//2
//5 4
//2 3 7 10 12
//1 5 7 8 
//3 3
//1 2 4
//1 2 7
//
//Output
//35 
//10
//
//Explanation:
//Testcase 1: For first test case the path will be 1+5+7+10+12 = 35.
//Testcase 2: For second test case the path will be 1+2 +7=10.
// O(m+n)

package Medium;

public class MaximumsumPath {

	public static void main(String[] args) {
		MaximumsumPath sumpath = new MaximumsumPath();
        int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
        int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        int m = ar1.length;
        int n = ar2.length;
        System.out.println("Maximum sum path is :" + 
                                       sumpath.maxPathSum(ar1, ar2, m, n));
	}
	
	int maxPathSum (int[] arr1, int[] arr2, int m, int n)
	{
		int i = 0, j = 0;
		int result = 0, s1 = 0, s2 = 0;
		
		while (i < m && j < n)
		{
			if (arr1[i] < arr2[j])
				s1 += arr1[i++];
			else if (arr2[j] < arr1[i])
				s2 += arr2[j++];
			else
			{
				// If both are equal, max of sum
				result += Math.max(s1, s2);
				
				s1 = 0; 
				s2 = 0;
				
				while (arr1[i] == arr2[j])
				{
					result += arr1[i];
					i++; j++;
				}
			}
		}
		
		while (i < m)
			result += arr1[i++];
		
		while (j < n)
			result += arr2[j++];
		
		return result;
	}
}
