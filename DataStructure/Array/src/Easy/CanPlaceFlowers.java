//Example 1:
//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: True
//Example 2:
//Input: flowerbed = [1,0,0,0,1], n = 2
//Output: False

package Easy;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++)
        {
            if (flowerbed[i] == 0)
            {
                int next = (i == flowerbed.length-1) ? 0 : flowerbed[i+1];
                int prev = i == 0 ? 0 : flowerbed[i-1];
                if (next == 0 && prev == 0)
                {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        
        return count == n;
    }
}
