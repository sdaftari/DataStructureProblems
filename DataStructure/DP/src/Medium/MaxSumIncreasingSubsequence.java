package Medium;

public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		MaxSumIncreasingSubsequence obj = new MaxSumIncreasingSubsequence();
		System.out.println(obj.maxSumIncreasingSubsequece(arr));
	}

	public int maxSumIncreasingSubsequece(int[] arr)
	{
		int n = arr.length;
		int i, j, max = 0;
		
		int[] msis = new int[20];
		
		for ( i = 0; i < n; i++ )
            msis[i] = arr[i];
		
		for (i = 1; i < n; i++)
		{
			for (j = 0; j < i; j++)
			{
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
				{
					msis[i] = msis[j] + arr[i];
				}
			}
		}
		
		for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];
 
        return max;
	}
}
