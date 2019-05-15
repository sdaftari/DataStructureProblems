//Example 2:
//Input: N = 7
//Output: 9
//Explanation: 
//We can at most get 9 A's on screen by pressing following key sequence:
//A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
// Time: O(N^2)


// 2 Key Keyboard
//Example 1:
//Input: 3
//Output: 3
//Explanation:
//Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.

package Extra;

public class Keys4Keyboard 
{

	public int maxA(int N) {
        int[] dp = new int[N + 1];
        // We use i steps to reach maxA(i) then use the remaining n - i steps to reach n - i - 1 copies of maxA(i)
        for (int i = 0; i <= N; i++)
        {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        
        return dp[N];
    }
	
	// Two Keys Keyboard
	public int minSteps(int n) 
	{
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) 
        {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) 
            {
                if (i % j == 0) 
                {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
