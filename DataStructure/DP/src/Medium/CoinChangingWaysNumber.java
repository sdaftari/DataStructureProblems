package Medium;

/*
 * Number of ways to get the total using given coins 
 * Fill first column with 1, since there is one way to return total 0 using 0 coins
 * if coin value is greater than total, take upper value as that coin wont be a part of total
 * else sum of ways considering that coin (go back that many number of coin value) + upper value for ignoring that coin
 * Complexity: O(length*total)
 */
public class CoinChangingWaysNumber {

	public static void main(String[] args) {
		CoinChangingWaysNumber cc = new CoinChangingWaysNumber();
        int total = 5;
        int coins[] = {1, 2, 5};
        System.out.println(cc.coinChangingNumber(coins, total));
	}
	
	public int coinChangingNumber(int[] coins, int total)
	{
		// we have single coin of that value
		int n = coins.length;
		int temp[][] = new int[n+1][total+1];
		
		// if the total is 0, then only 1 way no coin
		for(int i=0; i <= coins.length; i++)
            temp[i][0] = 1;
		
		for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
            	// if coin value is greater than total, take value from previous coin (upper row), equal to that amount
                if(coins[i-1] > j)
                {
                    temp[i][j] = temp[i-1][j];
                }
                else
                {
                	// if we get a coin value then go back that much value + 
                	// if we dont consider the coin value, then take value from top as #ways to get that value using prev coins
                	temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
	}
}
