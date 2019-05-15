//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//
//Note:
//The number of people is less than 1,100.
//
//
//Example
//
//Input:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//Output:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// Time: nlogn + n

package Medium;
import java.util.*;

public class QueueReconstructionByHeight {

	public int[][] reconstructQueue(int[][] people) 
	{
        // Sort array in decending order of height
        //If height is same, sort in ascending order based on #people infront of them 
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++)
        {
            // If the pos is grater than current index, shift elements until that pos
            int pos = people[i][1];
            for (int j = i; j > pos; j--)
                res[j] = res[j - 1];   
             
            // and replace the element at that pos
            res[pos] = people[i];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
