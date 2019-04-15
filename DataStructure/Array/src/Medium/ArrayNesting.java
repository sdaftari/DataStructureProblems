//Example 1:
//Input: A = [5,4,0,3,1,6,2]
//Output: 4
//Explanation: 
//A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
//One of the longest S[K]:
//S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

package Medium;

public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int size = 0;
            // Check if the number > 0, since we are making visited number -1
            for (int k = i; nums[k] >= 0; size++)
            {
                int numk = nums[k];
                nums[k] = -1;
                k = numk;
            }
            
            maxsize = Integer.max(maxsize, size);
        }
        
        return maxsize;
    }
}
