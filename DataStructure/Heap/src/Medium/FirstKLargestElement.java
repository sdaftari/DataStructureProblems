// Similar logic for sort nearly sorted array: 
// if k elements are sorted, build the minHeap: Complexity O(k)
// Then extract min and add remianing element
// O(k + (n-k)Logk) for w/o sorting output
// for sorted output O(k + (n-k)Logk + kLogk)

package Medium;

public class FirstKLargestElement {

	public static void main(String[] args) {
		int nums[] = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		int[] temp = new int[k]; 
		
		MinHeap objMinHeap = new MinHeap(k);
		
		// Complexity O(K)
		for (int i = 0; i < k; i++)
			objMinHeap.add(nums[i]);
		
		// Complexity: O(n-k) * log k
		for (int i = k; i < nums.length; i++)
		{
			// MinHEap will have largest k elements
			if (objMinHeap.getMin() < nums[i])
			{
				objMinHeap.extractMin();
				objMinHeap.add(nums[i]);
			}
		}
		
		int i = 0;
		while (i < k)
		{
			temp[i] = objMinHeap.extractMin();
			i++;
		}
		
		for (int j : temp)
			System.out.println(j);
	}

}
