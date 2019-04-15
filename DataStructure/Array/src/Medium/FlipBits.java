//Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.You have to do atmost one “Flip” operation of a subarray. 
//Then finally display maximum number of 1 you can have in the array.
//Example:
//Input:
//1
//5
//1 0 0 1 0 
//
//Output:
//4
//
//Explanation:
//We can perform a flip operation in the range [1,2]
//After flip operation array is : 1 1 1 1 0
// Time: O(n). Space: O(1)

package Medium;

public class FlipBits {
	
	private int flipBits(int[] arr)
	{
		if (arr == null || arr.length == 0)
			return 0;
		
		int countOne = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 1)
				countOne++;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == 0)
				arr[i] = 1;
			else 
				arr[i] = -1;
		}
		
		int sum = kadane(arr);
		
		return sum+countOne;
	}
	
	public int kadane(int[] nums) 
	{ 
		int maxSumSoFar = nums[0], maxSumEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            maxSumEndingHere = Math.max(maxSumEndingHere + nums[i], nums[i]);
            maxSumSoFar = Math.max(maxSumEndingHere, maxSumSoFar);
        }
        
        return maxSumSoFar; 
      } 

	public static void main(String[] args) {
		FlipBits obj = new FlipBits();
		int[] arr = {1, 0, 0, 1, 0};
		System.out.println(obj.flipBits(arr));
	}

}
