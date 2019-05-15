//Example 1:
//
//Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
//Output: [null,1,1,1,2,1,4,6]
//Explanation: 
//First, S = StockSpanner() is initialized.  Then:
//S.next(100) is called and returns 1,
//S.next(80) is called and returns 1,
//S.next(60) is called and returns 1,
//S.next(70) is called and returns 2,
//S.next(60) is called and returns 1,
//S.next(75) is called and returns 4,
//S.next(85) is called and returns 6.
//
//Note that (for example) S.next(75) returned 4, because the last 4 prices
//(including today's price of 75) were less than or equal to today's price.

package Medium;
import java.util.*;

public class OnlineStockPlan {
	
	Stack<int[]> stack = new Stack<>();
    public OnlineStockPlan() {
        
    }
    
    public int next(int price) {
        int res = 1;
        // if current value is greater, pop the values and count the # till it was less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        // Push if current value is less than last value
        stack.push(new int[]{price, res});
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
