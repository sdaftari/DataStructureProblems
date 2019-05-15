//Example: AddTwoNumbers I
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

//Add Two Numbers II
//Example:
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7

package Medium;
import java.util.*;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else
        {
            int carry = 0;
            ListNode sol = null; 
            while(l1 != null && l2 != null)
            {
                int data = l1.val + l2.val + carry;
                int value = data % 10;
                carry = data / 10;
                if (sol == null)
                {                    
                    sol = new ListNode(value);
                    head = sol;
                    sol.next = null;
                }
                else
                {
                    ListNode temp = new ListNode(value);
                    sol.next = temp;
                    sol = sol.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if (l1 != null)
            {
                while(l1 != null)
                {
                    if (carry > 0)
                    {
                        int data = l1.val + carry;
                        int value = data%10;
                        carry = data/10;
                        ListNode temp = new ListNode(value);
                        sol.next = temp;
                    }
                    else
                        sol.next = l1;
                    sol = sol.next;
                    l1 = l1.next;
                }
            }
            
            if (l2 != null)
            {
                while(l2 != null)
                {
                    if (carry > 0)
                    {
                        int data = l2.val + carry;
                        int value = data%10;
                        carry = data/10;
                        ListNode temp = new ListNode(value);
                        sol.next = temp;
                    }
                    else
                        sol.next = l2;
                    sol = sol.next;
                    l2 = l2.next;
                }
            }
            
            if (carry > 0)
            {
                ListNode temp = new ListNode(carry);
                sol.next = temp;
            }
        }
        
        return head;
    }
	
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) 
	{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while (l1 != null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode res = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if (!s1.isEmpty())
                sum += s1.pop();
            
            if (!s2.isEmpty())
                sum += s2.pop();
            
            res.val = sum%10;
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;
            sum /= 10;
        }
        
        return res.val == 0 ? res.next : res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
