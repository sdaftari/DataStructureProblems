//Input:
//letters = ["c", "f", "j"]
//target = "a"
//Output: "c"

// Time: O(logn)

package Easy;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        while(low <= high)
        {
            int mid = (high+low)/2;
            if(letters[mid] <= target)
                low = mid+1;
            else
                high = mid-1;
        }
        return low == letters.length ? letters[0] : letters[low];
    }
}
