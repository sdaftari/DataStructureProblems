//Input: 16
//Output: true
// O(log(n))

// Perfect Square
//Given an integer x. The task is to find the square root of x. If x is not a perfect square, then return floor(root(x)).

package Medium;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		ValidPerfectSquare obj = new ValidPerfectSquare();
		System.out.println(obj.perfectSquare(5));

	}

	public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) 
        {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) 
                return true;
            else if (mid * mid < num) 
                low = (int) mid + 1;
            else 
                high = (int) mid - 1;
        }
        return false;
    }
	
	public int perfectSquare(int num) {
        int low = 1, high = num;
        long mid = 0;
        while (low <= high) 
        {
            mid = (low + high) >>> 1;
            if (mid * mid == num) 
                return (int)mid;
            else if (mid * mid < num) 
                low = (int) mid + 1;
            else 
                high = (int) mid - 1;
        }
        return (int) mid;
    }
}
