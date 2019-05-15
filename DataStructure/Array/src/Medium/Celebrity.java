//You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. 
//Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
//Input: graph = [
//  [1,1,0],
//  [0,1,0],
//  [1,1,1]
//]
//Output: 1
//Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, 
//otherwise graph[i][j] = 0 means person i does not know person j. 
//The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

// Time: O(n)

package Medium;

public class Celebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	public int findCelebrity(int n) {
//        int candidate = 0;
//        for (int i = 0; i < n; i++)
//        {
//            if (knows(candidate, i))
//                candidate = i;
//        }
//        
//        for(int i = 0; i < n; i++)
//        {
//            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) 
//                return -1;
//        }
//        
//        return candidate;
//    }
}
