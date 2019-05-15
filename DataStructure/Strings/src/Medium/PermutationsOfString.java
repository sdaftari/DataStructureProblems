//Given a string S. The task is to print all permutations of a given string.
//Input:
//The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.
//Example:
//Input:
//2
//ABC
//ABSG
//
//Output:
//ABC ACB BAC BCA CAB CBA 
//ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
//
//Explanation:
//Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .

package Medium;

public class PermutationsOfString {
	
	// Function to print all the permutations of str 
    static void printPermutn(String str, String ans) 
    {   
        // If string is empty 
        if (str.length() == 0) 
        { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) 
        {  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  str.substring(i + 1); 
  
            // Recursive call 
            printPermutn(ros, ans + ch); 
        } 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
