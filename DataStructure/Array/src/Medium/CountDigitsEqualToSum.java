//Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’. Leading 0’s are not counted as digits. Print your output % 10^9+7.
//Example:
//
//Input:  n = 2, sum = 2
//Output: 2
//Explanation: Numbers are 11 and 20
//
//Input:  n = 2, sum = 5
//Output: 5
//Explanation: Numbers are 14, 23, 32, 41 and 50
//
//Input:  n = 3, sum = 6
//Output: 21
//
//Time Complexity: O(sum)
//Space Complexity: O(1)

package Medium;

public class CountDigitsEqualToSum {
	
	private static void findCount(int n, int sum) 
	{
        
        //in case n = 2 start is 10 and end is (100-1) = 99 
        int start = (int) Math.pow(10, n-1); 
        int end = (int) Math.pow(10, n)-1;  
      
        int count = 0; 
        int i = start; 
          
                while(i < end) { 
              
            int cur = 0; 
            int temp = i; 
              
            while( temp != 0) { 
                cur += temp % 10; 
                temp = temp / 10; 
            } 
              
            if(cur == sum) {              
                count++;              
                i += 9;          
            }else
                i++; 
              
        }      
        System.out.println(count); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
