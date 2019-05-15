//Given a robot cleaner in a room modeled as a grid.
//Each cell in the grid can be empty or blocked
//The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
//When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

package Extra;
import java.util.*;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
public class RobotRoomCleaner 
{
//	int[][] dir = {{1,0}, {0,1}, {-1,0}, {0, -1}};
//	public void cleanRoom(Robot robot) 
//	{
//        Set<String> visited = new HashSet<>();
//        clean(robot, 0, 0, 0, visited);
//    }
//
//	private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited)
//    {
//    	// Clean current cell.
//        robot.clean();
//        visited.add(x + " " + y);
//        
//        for (int i = 0; i < 4; i++) 
//        {
//        	// With the current position, try all 4 directions and if they are not visited or movable, clean it
//        	// Assume the initial direction is facing upwards
//            int nx = x + dir[curDirection][0];
//            int ny = y + dir[curDirection][1];
//            if (!visited.contains(nx + " " + ny) && robot.move()) {
//                clean(robot, nx, ny, curDirection, visited);
//            }
//            // Change orientation.
//            // Next direction is turn right and then explore
//            robot.turnRight();
//            curDirection++;
//            curDirection %= 4;
//        }
//        
//        // Move backward one step while maintaining the orientation.
//        // Next direction is 
//        robot.turnRight();
//        robot.turnRight();
//        robot.move();
//        robot.turnRight();
//        robot.turnRight();
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
