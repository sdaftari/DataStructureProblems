package Easy;

public class PrintNthFromLast 
{
	ListNode head;
	void printNthFromLast(int n)
	{
		ListNode mainPtr = head;
		ListNode refPtr = head;
		
		int count = 0;
		
		if (head != null)
		{
			// Move refPtr ahead n steps
			while(count < n)
			{
				if (refPtr != null)
				{
					refPtr = refPtr.next;
					count++;
				}
				else
					return;
			}
		}
		
		// Now mainPtr will be n steps behind the refPtr. 
		// So when refPtr reaches null, mainPtr reached n steps from end
		while (refPtr != null)
		{
			mainPtr = mainPtr.next;
			refPtr = refPtr.next;
		}
		
		System.out.println(mainPtr.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
