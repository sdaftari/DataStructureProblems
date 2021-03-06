//Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Time: O(n)


package Medium;
import java.util.*;

public class TopKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k) 
    {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) 
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        for (int key : frequencyMap.keySet()) 
        {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) 
                bucket[frequency] = new ArrayList<>();
            
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) 
        {
            if (bucket[pos] != null) 
                res.addAll(bucket[pos]);
        }
        return res;
    }
	
	public void topKFrequentInStream(int[] nums, int k) 
    {
//		PriorityQueue<Integer>[] bucket = new PriorityQueue[nums.length + 1];
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) 
        {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

	        for (int key : frequencyMap.keySet()) 
	        {
	            int frequency = frequencyMap.get(key);
	            if (bucket[frequency] == null) 
	                bucket[frequency] = new ArrayList<>();
	            
	            if (!bucket[frequency].contains((key)))
	            {
	            	bucket[frequency].add(key);
	            	bucket[frequency].sort((i1,i2) -> Integer.compare(i1, i2));
	            }
	        }
	
	        List<Integer> res = new ArrayList<>();
	
	        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) 
	        {
	            if (bucket[pos] != null) 
	            {
	            	List<Integer> temp = bucket[pos];
	            	for (Integer i : temp)
	            	{
		            	if (!res.contains(i))
		            		res.add(i);
	            	}
	            }
	        }
	        
	        for (Integer i : res)
	        	System.out.print(i + " ");
        }
    }

	public static void main(String[] args) {
		TopKFrequentElements obj = new TopKFrequentElements();
		int[] nums = {5, 2, 1, 3, 2};
		obj.topKFrequentInStream(nums, 4);
	}

}
