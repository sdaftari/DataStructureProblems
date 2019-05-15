//We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//(Here, the distance between two points on a plane is the Euclidean distance.)
// Time: O(nlog k)

package Medium;
import java.util.*;

public class KCLosestPointsToOrigin {
	
	// O(N)
    public int[][] kClosest(int[][] points, int K) 
    {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) 
        {
            int mid = helper(points, l, r);
            if (mid == K) 
                break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) 
    {
        int[] pivot = A[l];
        while (l < r) 
        {
            while (l < r && compare(A[r], pivot) >= 0) 
                r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) 
                l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

	// O(nlogk)
//	public int[][] kClosest(int[][] points, int K) {
//		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
//        for (int[] p : points)
//        {
//            pq.offer(p);
//            if (pq.size() > K) 
//                pq.poll();
//        }
//    
//        int[][] res = new int[K][2];
//        while (K > 0)
//        {
//            res[--K] = pq.poll();
//        }
//     
//        return res;
//    }
	
	public static void main(String[] args) {
		int[][] points = {{1,3},{-2,2}};
		int K = 1;
		KCLosestPointsToOrigin obj = new KCLosestPointsToOrigin();
		int[][] res = obj.kClosest(points, K);
	}

}
