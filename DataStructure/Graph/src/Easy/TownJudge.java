//If the town judge exists, then:
//The town judge trusts nobody.
//Everybody (except for the town judge) trusts the town judge.
//There is exactly one person that satisfies properties 1 and 2.
//You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

//Time O(T + N), space O(N)

package Easy;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust)
        {
            // trust[a, b] means a trusts b
            // so decrement count of a and increment of b
            count[t[0]]--;
            count[t[1]]++;
        }
        
        for (int i = 1; i <= N; ++i) 
        {
            // Since judge does not trust anybody, but everyone trusts judge, outdegree will be 0 and indegree will be N-1
            if (count[i] == N - 1) 
                return i;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
