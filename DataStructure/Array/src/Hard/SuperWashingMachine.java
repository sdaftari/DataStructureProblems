//You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty. For each move, you could choose any m (1 <= m <= n) washing machines, and pass one dress of each washing 
//machine to one of its adjacent washing machines at the same time. Given an integer array representing the number of dresses in each washing machine from left to right on the line, 
//you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
//Example1
//Input: [1,0,5]
//Output: 3
//Explanation: 
//1st move:    1     0 <-- 5    =>    1     1     4
//2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
//3rd move:    2     1 <-- 3    =>    2     2     2  
//Some other example:
//machines: [0,3,0]; gain/lose array: [-1,2,-1]; max = 2, cnt = 0, -1, 1, 0, its abs peak is 1. So result is 2.
//machines: [1,0,5]; gain/lose array: [-1,-2,3]; max = 3, cnt = 0, -1, -3, 0, its abs peak is 3. So result is 3.

// Time: O(n)

package Hard;

public class SuperWashingMachine {
	
	public int findMinMoves(int[] machines) 
	{
        int total = 0; 
        for(int i: machines) 
            total += i;
        if(total % machines.length != 0) 
            return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines)
        {
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
