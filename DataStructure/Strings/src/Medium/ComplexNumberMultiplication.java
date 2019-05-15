//Example 1:
//Input: "1+1i", "1+1i"
//Output: "0+2i"
//Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

package Medium;

public class ComplexNumberMultiplication {
	
	public String complexNumberMultiply(String a, String b) 
	{
        //(a+bi)(c+di) = (ac - bd) + (ad+bc)i.
        String result = "";
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        
        int a1 = Integer.parseInt(A[0]);
        int b1 = Integer.parseInt(A[1].replace("i",""));
        int a2 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replace("i",""));

        int a1a2 = a1 * a2;
        int b1b2 = b1 * b2;
        int a1b2a2b1 = (a1 * b2) + (b1 * a2);

        String afinal = (a1a2 + (-1 * b1b2)) + "";
        String bfinal = a1b2a2b1 + "i";
        result = afinal+"+"+bfinal;
        return result;  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
