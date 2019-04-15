// majorityElement
// Element appearing more than half
//Example 1:
//
//Input: [3,2,3]
//Output: 3

// Time: O(n)

// majorityElementII
// Time: O(n) and Space O(1)

package Easy;
import java.util.*;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int[] nums = new int[] {2,2,1,1,1,2,2};
		System.out.println(obj.majorityElement(nums));
	}

	public int majorityElement(int[] nums) 
	{
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (count == 0)
            {
                major = nums[i];
                count = 1;
            }
            else if (nums[i] == major)
                count++;
            else
                count--;
        }
        
        return major;
    }
	
	// Given an integer array of size n, find all elements that appear more than n/3 times.
	public List<Integer> majorityElementII(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        
        for (int n : nums)
        {
            if (major1 == n)
                count1++;
            else if (major2 == n)
                count2++;
            else if (count1 == 0)
            {
                major1 = n;
                count1 = 1;
            }
            else if (count2 == 0)
            {
                major2 = n;
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }  
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int n : nums)
        {
            if (n == major1)
                count1++;
            else if (n == major2)
                count2++;
        }
        
        if(count1 > nums.length / 3) list.add(major1); 
        if(count2 > nums.length / 3) list.add(major2);
        
        return list;
    }
}
