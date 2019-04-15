//The task is to complete the function  multiplyTwoLists which multiplies two linked lists l1 and l2 and returns their product . The function takes two linked list l1, l2 as its arguments. 
//
//Note: The output could be large take modulo 10^9+7.

package Medium;

public class MultiplyTwoLists {
	
	public long multiplyTwoLists(ListNode first, ListNode second)
	   {
	        long num1 = 0, num2 = 0; 
	        long N= 1000000007;
	      
	        // Generate numbers from linked lists 
	        while (first != null || second != null) 
	        { 
	            if (first != null) 
	            { 
	                num1 = ((num1%N)*10)%N + first.val; 
	                first = first.next; 
	            } 
	            if (second != null) 
	            { 
	                num2 = ((num2%N)*10)%N + second.val; 
	                second = second.next; 
	            } 
	        } 
	      
	        // Return multiplication of  
	        // two numbers 
	        return ((num1%N)*(num2%N))%N;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
