//Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
//Example:
//Input:
//4
//5
//15
//1 
//3
//Output:
//5
//10
//5
//4
//Explanation:
//Testcase 1:
//Flow in stream : 5, 15, 1, 3 
//5 goes to stream --> median 5 (5) 
//15 goes to stream --> median 10 (5, 15) 
//1 goes to stream --> median 5 (5, 15, 1) 
//3 goes to stream --> median 4 (5, 15, 1, 3) 
//O(log(n)) of add() and O(1) of getMedian()

package Hard;
import java.util.*;

public class MedianOfStream {
	
	PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;
 
    /** initialize your data structure here. */
    public MedianOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
 
    public void addNum(int num) 
    {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
 
        if(minHeap.size() < maxHeap.size())
            minHeap.offer(maxHeap.poll());
    }
 
    public double findMedian() 
    {
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else 
            return (minHeap.peek() + maxHeap.peek())/2.0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
