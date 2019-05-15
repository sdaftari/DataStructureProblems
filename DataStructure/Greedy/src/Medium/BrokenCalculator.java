//On a broken calculator that has a number showing on its display, we can perform two operations:
//Double: Multiply the number on the display by 2, or;
//Decrement: Subtract 1 from the number on the display.
//Initially, the calculator is displaying the number X.
//Return the minimum number of operations needed to display the number Y.

package Medium;

public class BrokenCalculator {
	
	public int brokenCalc(int X, int Y) 
	{
        int res = 0;
        while (Y > X) 
        {
        	// If its an odd number, add 1 and increment res.
        	// If its even, then just keep on dividing until Y is greater and then just add the difference for subtraction
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }

	public static void main(String[] args) {
		BrokenCalculator obj = new BrokenCalculator();
		System.out.println(obj.brokenCalc(3, 11));

	}

}
