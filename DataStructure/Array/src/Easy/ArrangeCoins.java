//Example 1:
//n = 5
//The coins can form the following rows:
//�
//� �
//� �
//Because the 3rd row is incomplete, we return 2.

// Time: O(n)

package Easy;

public class ArrangeCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int arrangeCoins(int n) {
        if(n < 1)
            return 0;
        for(int i=1; ; i++)
        {
            n -= i;
            if(n < 0)
                return i-1;
        }    
    }	
}
