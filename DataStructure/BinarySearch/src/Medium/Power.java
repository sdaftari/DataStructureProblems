//Example 1:
//
//Input: 2.00000, 10
//Output: 1024.00000

package Medium;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) 
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            else 
                n = -n;
            
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n /2) : x * myPow(x * x, n / 2);
    }
	
	public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x/2;
        while(true)
        {
            int mid = left + (right-left)/2;
            if (mid > x/mid)
                right = mid-1;
            else
            {
                if (mid+1 > x/(mid+1))
                    return mid;
                left = mid+1;
            }
        }
    }
}
