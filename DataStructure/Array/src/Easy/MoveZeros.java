//Example:
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]

//Time: O(n)

package Easy;

public class MoveZeros {

	public static void main(String[] args) {
		MoveZeros obj = new MoveZeros();
		int[] nums = new int[] {0,1,0,3,12};
		int[] res = obj.moveZeroes(nums);
		for (int i : res)
			System.out.print(i + " ");
	}

	public int[] moveZeroes(int[] nums) 
	{
        if (nums == null || nums.length == 0)
            return nums;
        
        int index = 0;
        
        for (int n : nums)
        {
            if (n != 0)
                nums[index++] = n;
        }
        
        while (index < nums.length)
                nums[index++] = 0;
        
        return nums;
    }
}
