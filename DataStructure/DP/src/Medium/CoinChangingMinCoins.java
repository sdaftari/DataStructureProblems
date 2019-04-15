package Medium;

/*
 * Minimum number of coins required to get the total
 * for 1st row, write a loop separately to find number of coins by dividing total with coin value, else put 0
 * for others, min of upper value or that value + go back for value of coin in same row
 * Complexity: O(length*total) * 
 */
public class CoinChangingMinCoins {

	public static void main(String[] args) {
		int total = 11;
		int[] coins = {1, 5, 6, 8};
		System.out.println(minNumberOfCoints(coins, total));
	}

	public static int minNumberOfCoints(int[] coins, int total)
	{
		int[] temp = new int[total+1];
		temp[0] = 0;
		
		for (int i = 1; i <= total; i++)
			temp[i] = Integer.MAX_VALUE;
		
		for(int j=0; j < coins.length; j++)
		{
            for(int i=1; i <= total; i++)
            {
            	// current total greater than current coin value 
            	// Ex: if we have total 1 and coin 5, then not possible
            	if(i >= coins[j])
            	{
            		// 1 coin of 5 , 5 coins of 1
            		// total - coin's value at j + 1 coin of jth value < current number of coins
            		if (temp[i - coins[j]] + 1 < temp[i])
            			temp[i] = 1 + temp[i - coins[j]];
            	}
            }
        }
				
		return temp[total];	
	}
}
