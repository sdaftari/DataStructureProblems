//Iterate through array, find sum including and excluding that number. While excluding, take max of previous (inc, exc)
//Complexity O(n)

package Medium;

public class MaximumSumSuchThatNoTwoElementsAreConsecutive {

	public static void main(String[] args) {
		MaximumSumSuchThatNoTwoElementsAreConsecutive sum = new MaximumSumSuchThatNoTwoElementsAreConsecutive();
		int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(sum.FindMaxSum(arr));
	}
	
	int FindMaxSum(int[] arr)
	{
		int incSum = arr[0];
		int exeSum = 0;
		int excNew = 0;
		
		for(int i = 1; i < arr.length; i++)
		{
			// Max sum without including the current element
			// i.e. max sum till i-1
			excNew = Math.max(incSum, exeSum);
			incSum = exeSum + arr[i];
			exeSum = excNew;
		}
		
		return Math.max(incSum, excNew);
	}
}
