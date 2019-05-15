//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
//Examples: 
//[2,3,4] , the median is 3
//[2,3], the median is (2 + 3) / 2 = 2.5
//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. 
//Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
//For example,
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//Window position                Median
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
//Therefore, return the median sliding window as [1,-1,-1,3,5,6].

package Hard;
import java.util.*;

public class SlidingWindowMedian {
	
	static class myInteger
	{
        int val;
        int index;
        myInteger(int val,int index)
        {
            this.val = val;
            this.index = index;
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) 
    {
        TreeSet<myInteger> minheap = new TreeSet<>(new Comparator<myInteger>()
        {
               public int compare(myInteger a,myInteger b)
               {
                   if(a.val!=b.val)
                   {
                       if(a.val<b.val)
                           return -1;
                       else
                           return 1;
                   }
                   else
                       return a.index-b.index;
               }
        });
        TreeSet<myInteger> maxheap = new TreeSet<>(new Comparator<myInteger>()
        {
        	public int compare(myInteger a,myInteger b)
        	{
        		if(a.val!=b.val)
        		{
        			if(a.val<b.val)
        				return -1;
                     else
                    	 return 1;
                 }else
               return a.index - b.index;
               }
        });
        
        Deque<myInteger> deque  = new ArrayDeque<>();
        double[] res = new double[nums.length-k+1];
        for(int i=0;i<k;i++)
        {
            myInteger temp = new myInteger(nums[i],i);
            deque.offer(temp);
            maxheap.add(temp);
        }
        balance(minheap,maxheap);
        //System.out.println("size of minheap :" + minheap.size() + " and the size of maxheap is : " + maxheap.size());
        
        res[0] = getmedian(minheap,maxheap);
        int p=1;
        for(int i=k;i<nums.length;i++)
        {
            myInteger removeEle = deque.pollFirst();
            if(minheap.contains(removeEle))
                minheap.remove(removeEle);
            else
                maxheap.remove(removeEle);
            
            myInteger newEle = new myInteger(nums[i],i);
            deque.offer(newEle);
            maxheap.add(newEle);
            minheap.add(maxheap.pollLast());
            balance(minheap,maxheap);
            res[p++] = getmedian(minheap,maxheap);
        }
        return res;
        
    }
    
    public double getmedian(TreeSet<myInteger> minHeap,TreeSet<myInteger> maxHeap)
    {
        if(minHeap.size()>maxHeap.size())
            return (double)minHeap.first().val;
        
        return ((double)minHeap.first().val+(double)maxHeap.last().val)/2.0;
    }
    
    
    public void balance(TreeSet<myInteger> minHeap,TreeSet<myInteger> maxHeap)
    {
          while(maxHeap.size()>minHeap.size())
              minHeap.add(maxHeap.pollLast());
          
          while(maxHeap.size()<minHeap.size()-1)
              maxHeap.add(minHeap.pollFirst());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
