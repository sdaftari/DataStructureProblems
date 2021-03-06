//Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
//Example:
//	Input:
//	2
//	5
//	3 30 34 5 9
//	4
//	54 546 548 60
//
//	Output:
//	9534330
//	6054854654

package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		LargestNumber objLargestNumber = new LargestNumber();
		System.out.println(objLargestNumber.getLargestNumber(nums));
	}
	
	private String getLargestNumber(int[] nums)
	{
		if (nums == null || nums.length < 1)
			return "";
		
		String[] s_nums = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			s_nums[i] = String.valueOf(nums[i]);
		
		Comparator<String> comp = new Comparator<String>() 
		{
			public int compare (String str1, String str2)
			{
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};
		
		Arrays.sort(s_nums, comp);
		
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_nums[0].charAt(0) == '0')
            return "0";
    
		StringBuilder sb = new StringBuilder();
		for(String s: s_nums)
			sb.append(s);
		
		return sb.toString();
	}
}
