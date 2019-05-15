//Example 1:
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]] 
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Time: O(kLogk)

package Medium;
import java.util.*;

public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) 
	{
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        
        if(nums1.length==0 || nums2.length==0 || k==0) 
            return res;
        
        // Add all elements of first array along with first element of second array and index of element
        for(int i=0; i<nums1.length && i<k; i++) 
            que.offer(new int[]{nums1[i], nums2[0], 0});
        
        while(k-- > 0 && !que.isEmpty())
        {
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            
            // If curr[2] has reached the array2 length then continue with already added elements
            if(cur[2] == nums2.length-1) 
                continue;
            
            // Otherwise add first element of first array with the next element of second array
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
