//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//Output: [1,2,2,3,5,6]

// Time: O(n)

package Easy;

public class MergeSortedArrays {

	public static void main(String[] args) {
		MergeSortedArrays obj = new MergeSortedArrays();
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		int[] res = obj.merge(nums1, 3, nums2, 3);
		for (int i : res)
			System.out.print(i + " ");
	}

	public int[] merge(int[] nums1, int m, int[] nums2, int n) 
	{
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
        while (i >= 0 && j >= 0)
        {
            if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
        }
        
        while(j >= 0)
			nums1[k--] = nums2[j--];
        
        return nums1;
    }
}
