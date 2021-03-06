package Medium;

class PolyNode
{
    int coeff;
    int pow;
    PolyNode next;
    PolyNode(){}
    PolyNode(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}

public class PolynomialAddition 
{
	
	
	public static void addPolynomial(PolyNode p1,PolyNode p2)
    {
		PolyNode poly; 
		PolyNode dummy = new PolyNode(0, 0);
		poly = dummy;
		
        int pow = 0, coef = 0;
        while(p1 != null && p2 != null) 
        { 
            // If power of 1st polynomial is greater then 2nd, then store 1st as it is 
            // and move its pointer 
            if(p1.pow > p2.pow) 
            { 
                pow = p1.pow; 
                coef = p1.coeff; 
                p1 = p1.next; 
            } 
              
            // If power of 2nd polynomial is greater then 1st, then store 2nd as it is 
            // and move its pointer 
            else if(p1.pow < p2.pow) 
            { 
                pow = p2.pow; 
                coef = p2.coeff; 
                p2 = p2.next; 
            } 
              
            // If power of both polynomial numbers is same then add their coefficients 
            else
            { 
                pow = p1.pow; 
                coef = p1.coeff+p2.coeff; 
                p1 = p1.next; 
                p2 = p2.next; 
            } 
              
            // Dynamically create new node 
            poly.next = new PolyNode(coef, pow);  
            poly = poly.next;            
        }
        
        while(p1 != null || p2 != null) 
        { 
            if(p1 != null) 
            { 
                pow = p1.pow; 
                coef = p1.coeff; 
                p1 = p1.next; 
            } 
            if(p2 != null) 
            { 
                pow = p2.pow; 
                coef = p2.coeff; 
                p2 = p2.next; 
            } 
            poly.next = new PolyNode(coef, pow);
            poly = poly.next; 
        }
        
        poly = dummy.next;
        while (poly != null)
        {
            System.out.print(poly.coeff + "X" + poly.pow);            
            poly = poly.next;
            if (poly != null)
            	System.out.print("+");
        }
    }

	public static void main(String[] args) {
		PolyNode p1 = new PolyNode(1, 2);
		PolyNode p2 = new PolyNode(1, 3);
		addPolynomial(p1,p2);
	}

}
