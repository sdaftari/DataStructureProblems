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
