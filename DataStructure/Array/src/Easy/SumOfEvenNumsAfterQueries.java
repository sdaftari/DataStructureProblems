//Example 1:
//Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//Output: [8,6,2,4]
//Explanation: 
//At the beginning, the array is [1,2,3,4].
//After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
//After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
//After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
//After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

// Time: O()

package Easy;

public class SumOfEvenNumsAfterQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = sumEven(A);
        int[] ans = new int [queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            int val = queries[i][0];
            int index = queries[i][1];
            
            // Get the original value
            int valIndex = A[index];
            // Calculate the updated value
            int updatedValue = valIndex + val;
            
            // if both original and updated values are even numbers 
            if(valIndex % 2 == 0 && updatedValue % 2 == 0)
                sum += updatedValue - valIndex;
            // If original value is not even, but the updated is, add updated to sum
            else if(valIndex % 2 != 0 && updatedValue % 2 == 0)
                sum += updatedValue;
            // If original is even and new is not, subtract the original value from sum
            else if(valIndex % 2 == 0 && updatedValue % 2 != 0)
                sum -= valIndex;
            
            A[index] = updatedValue;
            ans[i] = sum;
        }
        
        return ans;
    }
    
    public int sumEven(int[] A)
    {
        int sum = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] % 2 == 0)
                sum += A[i];
        }
        return sum;
    }

}
