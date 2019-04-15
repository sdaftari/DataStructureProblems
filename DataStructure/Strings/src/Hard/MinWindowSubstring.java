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
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {
                counter--;
            }
            arr[rc]--;

            while (counter == 0) {
                if (right - left < window) {
                    window = right - (head = left);
                }

                char lc = s.charAt(left++);
                if (arr[lc] == 0) {
                    counter++;
                }
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
