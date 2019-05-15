//Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
//Example 1:
//Input: 5
//Output: 2
//Explanation: 5 = 5 = 2 + 3
//Example 2:
//
//Input: 9
//Output: 3
//Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4

package Hard;

public class ConsecutiveNumbersSum {
	
	int consecutiveNumbersSum(int N) 
	{
        int ans = 0;
        for (int m = 1; ; m++) 
        {
            int mx = N - m * (m-1) / 2;
            if (mx <= 0)
                break;
            if (mx % m == 0)
                ans++;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
