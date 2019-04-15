//Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists. If more than one such range's are found, print the first such range found.
//
//Input:
//K = 3
//A[] : [4, 7, 9, 12, 15]
//B[] : [0, 8, 10, 14, 20]
//C[] : [6, 12, 16, 30, 50]
//
//Output:
//The smallest range is [6 8] 
//Explanation: Smallest range is formed by number 7
//from first list, 8 from second list and 6 from third list.

package Medium;
import java.util.*;

public class SmallestRangeInKLists {
	
	public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) 
        {
            q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) 
        {
            int e[] = q.poll(), row = e[0], col = e[1];
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
		// TODO Auto-generated method stub

	}

}
