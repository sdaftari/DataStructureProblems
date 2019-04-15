//A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
//For example, these are arithmetic sequence:
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9

package Medium;

public class ArithmaticSlices {
	
	public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int sum = 0;
        int len = 2;
        
        for(int i = 2; i < A.length; i++)
        {
            // keep increasing the splice
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) 
                len++;
            // If the sequence is discontinued, we will calculate the number for that part
            else
            {
                if(len > 2) 
                    sum += calculateSlices(len);
                // reset the length of new slice
                len = 2;
            }
        }
        
        // add up the slice in the rear. This will be executed for last part of slice
        if(len > 2)
            sum += calculateSlices(len);

        return sum;
    }
    
    private int calculateSlices(int n)
    {
        return (n-1)*(n-2)/2;
    }

	public static void main(String[] args) {
		int[] A = {1, 3, 5, 7, 9, 12, 13, 14};
		ArithmaticSlices obj = new ArithmaticSlices();
		System.out.println(obj.numberOfArithmeticSlices(A));
	}

}