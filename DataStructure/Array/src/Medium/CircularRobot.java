//Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if first and last positions of robot are same. A move can be on of the following.
//
//  G - Go one unit
//  L - Turn left
//  R - Turn right 
//Examples:
//
//Input: path[] = "GLGLGLG"
//Output: Given sequence of moves is circular 
//
//Input: path[] = "GLLG"
//Output: Given sequence of moves is circular 
//Time Complexity: O(n) where n is number of moves in given sequence.

package Medium;

public class CircularRobot {
	// Macros for East, North, South and West 
	  
	// This function returns true if the given path is circular, else false 
	static boolean isCircular(char path[]) 
	{ 
	  // Initialize starting point for robot as (0, 0) and starting direction as N North 
	  int x = 0, y = 0; 
	  int dir = 0; 
	   
	  // Traverse the path given for robot 
	  for (int i = 0; i < path.length; i++) 
	  { 
	      // Find current move 
	      char move = path[i]; 
	   
	      // If move is left or right, then change direction 
	      if (move == 'R') 
	        dir = (dir + 1)%4; 
	      else if (move == 'L') 
	        dir = (4 + dir - 1) % 4; 
	   
	      // If move is Go, then change  x or y according to current direction 
	      else // if (move == 'G') 
	      { 
	         if (dir == 0) // up
	            y++; 
	         else if (dir == 1) //right
	            x++; 
	         else if (dir == 2) //down
	            y--; 
	         else // dir == 3 // left
	            x--; 
	      } 
	  } 
	   
	   // If robot comes back to 
	   // (0, 0), then path is cyclic 
	  return (x == 0 && y == 0); 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
