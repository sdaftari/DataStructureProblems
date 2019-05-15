//You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
//We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
////Example 1:
//Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//Output: [20,24]
//Explanation: 
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].

package Medium;
import java.util.*;

public class SmallestRange {
	
	public int[] smallestRange(List<List<Integer>> nums) 
	{        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        // Offer the first element in each list
        for (int i = 0; i < nums.size(); i++) 
        {
            q.offer(new int[]{i, 0});
            // Saves the max of first numbers in lists
            max = Math.max(max, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) 
        {
            int e[] = q.poll();
            int row = e[0], col = e[1];
            if (end - start > max - nums.get(row).get(col)) 
            {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) 
            {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }

	public static void main(String[] args) {
		List<Integer> a1 = Arrays.asList(4, 10, 15, 24,26);
		List<Integer> a2 = Arrays.asList(0,9,12,20);
		List<Integer> a3 = Arrays.asList(5,18,22,30);
		List<List<Integer>> a = new ArrayList<>();
		a.add(a1);
		a.add(a2);
		a.add(a3);
		
		SmallestRange obj = new SmallestRange();
		int[] ans = obj.smallestRange(a);
	}

}
