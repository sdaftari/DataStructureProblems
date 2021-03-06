//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//" -90e3   " => true
//" 1e" => false
//"e3" => false
//" 6e-1" => true
//" 99e2.5 " => false
//"53.5e93" => true
//" --6 " => false
//"-+3" => false
//"95a54e53" => false
//
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
//
//Numbers 0-9
//Exponent - "e"
//Positive/negative sign - "+"/"-"
//Decimal point - "."

package Hard;

public class ValidNumber {

	public boolean isNumber(String s) 
	{
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) 
        {
        	// If its a number between 0-9, make numberseen = true and numberAfterE true
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') 
            {
                numberSeen = true;
                numberAfterE = true;
            } 
            // If . is encountered, check if . is already seen or e is seen
            else if(s.charAt(i) == '.') 
            {
                if(eSeen || pointSeen) 
                    return false;
                // If . is not seen already, make it seen
                pointSeen = true;
            } 
            else if(s.charAt(i) == 'e') 
            {
                if(eSeen || !numberSeen) 
                    return false;
                
                numberAfterE = false;
                eSeen = true;
            } 
            else if(s.charAt(i) == '-' || s.charAt(i) == '+') 
            {
                if(i != 0 && s.charAt(i-1) != 'e') 
                    return false;
            } 
            else 
                return false;
        }

        return numberSeen && numberAfterE;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
