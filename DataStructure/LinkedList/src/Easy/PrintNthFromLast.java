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
