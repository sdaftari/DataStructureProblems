//Example 1:
//Given nums = [3,2,2,3], val = 3,
//Your function should return length = 2, with the first two elements of nums being 2.
//It doesn't matter what you leave beyond the returned length.

package Easy;

public class RemoveElements {
	
	public int removeElement(int[] nums, int val) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        int k = 0;
        for (int n: nums) 
        {
            if (n != val) 
                nums[k++] = n;
        }
        return k;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}