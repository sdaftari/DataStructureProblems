//Example:
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// Time: O(n)

package Hard;

public class MinWindowSubstring {
	 
	public String minWindow(String s, String t) 
	{
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) 
        {
        	// Move to right and decrement the counter when the character from pattern is found
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {
                counter--;
            }
            arr[rc]--;

            // Once the counter is zero, move the left pointer
            while (counter == 0) 
            {
                if (right - left < window) 
                {
                    window = right - left;
                    head = left;
                }

                char lc = s.charAt(left++);
                // Increment the counter only if the count current left is 0
                if (arr[lc] == 0) {
                    counter++;
                }
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinWindowSubstring obj = new MinWindowSubstring();
		System.out.println(obj.minWindow(s, t));
	}

}
