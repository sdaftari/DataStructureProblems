package Easy;

public class AddStrings {
	
	public String addStrings(String num1, String num2) 
	{
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1, carry = 0;
        while(i >= 0 || j >= 0)
        {
            int sum = carry;
            if (j >= 0) 
                sum += num2.charAt(j--) - '0';
            if (i >= 0) 
                sum += num1.charAt(i--) - '0';
            sb.append(sum % 10);
            carry= sum / 10;
        }
        
        if (carry != 0) 
            sb.append(carry);
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		String num1 = "10";
		String num2 = "20";
		AddStrings obj = new AddStrings();
		System.out.println(obj.addStrings(num1, num2));
	}

}
