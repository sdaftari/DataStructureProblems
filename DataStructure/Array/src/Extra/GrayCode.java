//Example 1:
//
//Input: 2
//Output: [0,1,3,2]
//Explanation:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//For a given n, a gray code sequence may not be uniquely defined.
//For example, [0,2,3,1] is also a valid gray code sequence.
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1

package Extra;
import java.util.*;

public class GrayCode {
	
	public List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<Integer>();
        rs.add(0);
        for(int i = 0; i < n; i++)
        {
            int size = rs.size();
            for(int k = size-1; k >= 0; k--)
                rs.add(rs.get(k) | 1 << i);
        }
        return rs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
