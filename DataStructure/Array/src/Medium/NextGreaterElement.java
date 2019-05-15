//Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.
//Example:
//Input
//2
//143
//431
//
//Output
//314
//not possible


package Medium;

public class NextGreaterElement {
	
	public int nextGreaterElement(int n) {
        char[] s = (""+n).toCharArray();
        int i = s.length - 2;
        // I) Start from the right most digit and 
        // find the first digit that is smaller than the digit next to it.
        while (i >= 0 && s[i+1] <= s[i])
            i--;
        
        // If no such digit is found, its the edge case 1.
        if (i < 0)
            return -1;
        
        // II) Find the smallest digit on right side of (i-1)'th 
        // digit that is greater than number[i-1]
        int j = s.length - 1;
        // Get j such that a[i] < a[j]
        while (j >= 0 && s[j] <= s[i])
            j--;
        
        // III) Swap the above found smallest digit with 
        // number[i-1]
        swap(s, i, j);
        reverse(s, i+1);
        try{
            return Integer.parseInt(new String(s));
        }
        catch(Exception e) {
            return -1;
        }
    }
    
    public void swap(char[] s, int i, int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    public void reverse(char[] s, int start)
    {
        int i = start, j = s.length - 1;
        while (i < j)
        {
            swap(s, i, j);
            i++;
            j--;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
