//Example 1:
//Input: [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

// Time: O(n^2)

package Easy;

public class FlippingAnImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
        {
            for (int i = 0; i * 2 < n; i++)
            {
                // compare the i th and n - i - 1 th in a row. If they are same, we toggle both. Otherwise we do nothing.
                if (row[i] == row[n-i-1])
                    row[i] = row[n-i-1] ^= 1;
            }
        }
        
        return A;
    }
}
