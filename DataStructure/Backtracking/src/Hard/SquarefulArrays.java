//Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
//Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
//Example 1:
//Input: [1,17,8]
//Output: 2
//Explanation: 
//[1,8,17] and [17,8,1] are the valid permutations.
//Example 2:
//Input: [2,2,2]
//Output: 1

package Hard;
import java.util.*;

public class SquarefulArrays {
	private int count = 0;
	public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        helper(new ArrayList<>(), A,new boolean[A.length], -1);
        return count; 
    }
    
    private boolean isSquare(int a, int b){
        double sqr = Math.sqrt(a+b);
        boolean res = (sqr - Math.floor(sqr)) == 0;
        return res;
    }
        
    private void helper(List<Integer> temp, int[] A, boolean[] used, int lastNumber)
    {
        if (temp.size() == A.length)
            count++;
        else 
        {
            for (int i = 0; i < A.length; i++)
            {
            	// If current number is used or if we have duplicates and previous is not used, return            	
                if (used[i] || (i > 0 && A[i] == A[i-1] && !used[i-1]))
                    continue;
                // If its not the first number of the two numbers
                if (lastNumber != -1)
                {
                	// if we cant form a square we can not proceed to form a squareful array
                    if (isSquare(A[i], lastNumber) == false)
                        continue;
                }
                used[i] = true;
                temp.add(A[i]);
                helper(temp,A, used, A[i]);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
        
    }
	
	public static void main(String[] args) {
		int[] A = {1,17,8};
		SquarefulArrays obj = new SquarefulArrays();
		System.out.println(obj.numSquarefulPerms(A));
	}

}
