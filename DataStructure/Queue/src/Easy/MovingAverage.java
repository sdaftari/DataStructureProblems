package Easy;
import java.util.*;

public class MovingAverage {
	
	private Queue<Integer> queue;
    private int size;
    private double average;
    
    public MovingAverage(int size)
    {
    	queue = new LinkedList<>();
    	this.size = size;
    	average = 0;
    }
    
    public double next(int val)
    {
    	double sum = queue.size() * average;
    	int remove = 0;
    	if (queue.size() == size)
    		remove = queue.poll();
    	queue.offer(val);
    	average = (sum-remove+val)/queue.size();
    	return average;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
