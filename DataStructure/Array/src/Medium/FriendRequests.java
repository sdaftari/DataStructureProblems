//Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 
//Person A will NOT friend request person B (B != A) if any of the following conditions are true:
//age[B] <= 0.5 * age[A] + 7
//age[B] > age[A]
//age[B] > 100 && age[A] < 100
//Otherwise, A will friend request B.
//Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
//How many total friend requests are made?
//
//Example 1:
//Input: [16,16]
//Output: 2
//Explanation: 2 people friend request each other.
//
//Example 2:
//Input: [16,17,18]
//Output: 2
//Explanation: Friend requests are made 17 -> 16, 18 -> 17.


package Medium;

public class FriendRequests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numFriendRequests(int[] ages) {
        int[] map = new int[121];
        
        for(int age:ages)
            map[age]++;
        
        for(int i=1;i<map.length;i++)
            map[i] += map[i-1];
        
        int friendRequest = 0;
        for(int age:ages)
            friendRequest += Math.max(0, map[age] - map[(age/2)+7] - 1);
        
        return friendRequest;
    }
}
