package Medium;
import java.util.*;

public class KthSmallestElementInMatrix {

	public static void main(String[] args) {
		KthSmallestElementInMatrix objKthSmallestElement = new KthSmallestElementInMatrix();
		int matrix[][] = {
			{1,  5,  9},
		    {10, 11, 13},
		    {12, 13, 15}
		};
		
		System.out.println(objKthSmallestElement.kthSmallestElement(matrix, 8));
	}
	
	private int kthSmallestElement(int matrix[][], int k)
	{
		int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        
        // Offer first row to priority queue
        for(int j = 0; j <= n-1; j++) 
        	pq.offer(new Tuple(0, j, matrix[0][j]));
        
        // For k elements, poll element and add new element in queue
        for(int i = 0; i < k-1; i++) 
        {
        	Tuple t = pq.poll();
        	if(t.x == n-1) 
        		continue;
        	// the next element is from same column but next row
        	pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        
        return pq.poll().val;
	}
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
