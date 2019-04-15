//Given a pattern containing only I's and D's. I for increasing and D for decreasing.
//Devise an algorithm to print the minimum number following that pattern.
//Digits from 1-9 and digits can't repeat.
//Example:
//Input
//5
//D
//I
//DD
//IIDDD
//DDIDDIID
//
//Output
//21
//12
//321
//126543
//321654798


//The idea is to iterate over the entire input array , keeping track of the minimum number (1-9) which can be placed at that position of the output.
//The tricky part of course occurs when ‘D’ is encountered at index other than 0. In such a case we have to track the nearest ‘I’ to the left of ‘D’ and increment each number in the output vector by 1 in between 
//‘I’ and ‘D’. We cover the base case as follows:
//If the first character of input is ‘I’ then we append 1 and 2 in the output vector and the minimum available number is set to 3 .The index of most recent ‘I’ is set to 1.
//If the first character of input is ‘D’ then we append 2 and 1 in the output vector and the minimum available number is set to 3, and the index of most recent ‘I’ is set to 0.
//Now we iterate the input string from index 1 till its end and:
//If the character scanned is ‘I’ ,minimum value which has not been used yet is appended to the output vector .We increment the value of minimum no. available and index of most recent ‘I’ is also updated.
//If the character scanned is ‘D’ at index i of input array, we append the ith element from output vector in the output and track the nearest ‘I’ to the left of ‘D’ and increment each number in the output vector by 1 in between ‘I’ and ‘D’.

package Medium;
import java.util.*;

public class NumberFollowingPattern {
	
	static void printLeast(String arr) 
    { 
           // min_avail represents the minimum number which is  
           // still available for inserting in the output vector.  
           // pos_of_I keeps track of the most recent index  
           // where 'I' was encountered w.r.t the output vector  
           int min_avail = 1, pos_of_I = 0;  

           //vector to store the output 
           ArrayList<Integer> al = new ArrayList<>(); 
             
           // cover the base cases 
           if (arr.charAt(0) == 'I')  
           {  
               al.add(1);  
               al.add(2);  
               min_avail = 3;  
               pos_of_I = 1;  
           }  

           else
           { 
               al.add(2); 
               al.add(1); 
               min_avail = 3;  
               pos_of_I = 0;  
           } 

           // Traverse rest of the input 
           for (int i = 1; i < arr.length(); i++) 
           { 
                if (arr.charAt(i) == 'I') 
                { 
                    al.add(min_avail); 
                    min_avail++; 
                    pos_of_I = i + 1; 
                } 
                else
                { 
                    al.add(al.get(i)); 
                    for (int j = pos_of_I; j <= i; j++) 
                         al.set(j, al.get(j) + 1); 

                    min_avail++; 
                } 
           } 

           // print the number 
           for (int i = 0; i < al.size(); i++) 
                System.out.print(al.get(i) + " "); 
           System.out.println(); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
