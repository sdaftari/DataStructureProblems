//Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is �00100101�, then there are three substrings �1001�, �100101� and �101�.
//Example:
//Input:
//2
//4
//1111
//5
//01101
//
//Output:
//6
//3
//
//Example:
//Testcase 1: There are 6 substrings from the given string. They are 11, 11, 11, 111, 111, 1111.
//Testcase 2: There 3 substrings from the given string. They are 11, 101, 1101.
//
//Time: O(n)

package Easy;


//a) Count the number of 1�s. Let the count of 1�s be m.
//b) Return m(m-1)/2
//The idea is to count total number of possible pairs of 1�s.
public class BinaryString {

	int countSubStr(char str[], int n)  
    { 
        int m = 0; // Count of 1's in input string 
  
        // Traverse input string and count of 1's in it 
        for (int i = 0; i < n; i++)  
        { 
            if (str[i] == '1') 
                m++; 
        } 
  
        // Return count of possible pairs among m 1's 
        return m * (m - 1) / 2; 
    } 
	
	public static void main(String[] args) {
		BinaryString obj = new BinaryString();
		System.out.println(obj.countSubStr("10101".toCharArray(), 5));

	}

}
