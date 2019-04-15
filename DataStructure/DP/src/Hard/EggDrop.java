//Example 1:
//Input: K = 1, N = 2
//Output: 2
//Explanation: 
//Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
//Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
//If it didn't break, then we know with certainty F = 2.
//Hence, we needed 2 moves in the worst case to know what F is with certainty.

package Hard;

public class EggDrop {
	
	public int superEggDrop(int K, int N) 
	{
        int[][] dp = new int[N + 1][K + 1];
        int f = 0;
        while (dp[f][K] < N) 
        {
            f++;
            for (int e = 1; e <= K; e++)
                dp[f][e] = dp[f - 1][e - 1] + dp[f - 1][e] + 1;
        }
        return f;
    }

	public static void main(String[] args) {
		EggDrop obj = new EggDrop();
		System.out.println(obj.superEggDrop(2, 10));
	}

}
