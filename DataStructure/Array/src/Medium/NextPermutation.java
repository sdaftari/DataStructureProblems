//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//1,2,3 - 1,3,2
//3,2,1 - 1,2,3
//1,1,5 - 1,5,1

// Time: ?. Space: In-place

package Medium;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		obj.nextPermutation(new int[] {1,4,5,3,2});
	}
	
	public void nextPermutation(int[] nums) 
	{
        if(nums.length<=1)
            return;
        int i = nums.length-1;
        for (; i >= 1; i--)
        {
            //find first number which is smaller than it's after number
        	// in case if 1,2,3, i will be 3
            if (nums[i] > nums[i-1])
                break;
        }
        
        // Swap numbers from i-1 to end
        if (i != 0)
            swap(nums, i-1);
        
        // Reverse numbers from i to end
        reverse(nums, i);
        
        for (int j : nums)
        	System.out.print(j + " ");
    }
    
    private void swap(int[] a,int i)
    {
        for(int j = a.length-1; j > i; j--)
        {
            if(a[j] > a[i])
            {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }
    
    //reverse the number after the number we have found
    private void reverse(int[] a,int i)
    {
        int first = i;
        int last = a.length-1;
        while(first < last)
        {
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }

}
