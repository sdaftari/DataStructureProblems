// Wiggle Sort
//Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//Example:
//Input: nums = [3,5,2,1,6,4]
//Output: One possible answer is [3,5,1,6,2,4]
// Time: O(n). Space: In-place

// SortInWave
//Given a sorted array arr[] of non-repeating integers without duplicates. Sort the array into a wave-like array and return it. In other words, 
//arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... (considering the increasing lexicographical order).
//Example:
//Input:
//1
//5
//1 2 3 4 5
//Output:
//2 1 4 3 5
//
//Explanation:
//Testcase 1: Array elements after sorting it in wave form are 2 1 4 3 5 .
// O(n)

package Medium;

public class WiggleSort {

	public static void main(String[] args) {
		int[] nums = {4, 3, 7, 8, 6, 2, 1};
		WiggleSort obj = new WiggleSort();
		obj.wiggleSort(nums, nums.length);
	}

	public void wiggleSort(int[] arr, int n) 
    {
		for (int i = 0; i < n; i+=2)
		{
			if (i > 0 && arr[i-1] < arr[i])
				swap(arr, i-1, i); 
			
			if (i < (n-1) && arr[i] > arr[i+1])
				swap(arr, i, i+1);
		}
		
		for (int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");
    }
	
	void sortInWave(int[] arr, int n)
	{
		for (int i = 0; i < n; i+=2)
		{
			if (i > 0 && arr[i-1] > arr[i])
				swap(arr, i-1, i); 
			
			if (i < (n-1) && arr[i] < arr[i+1])
				swap(arr, i, i+1);
		}
	}
	
	void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
