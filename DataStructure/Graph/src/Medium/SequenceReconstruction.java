//Example:
//Input:
//org: [1,2,3], seqs: [[1,2]]
//Output:
//false
//Explanation:
//The reconstructed sequence can only be [1,2].
//
//Example:
//Input:
//org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
//Output:
//true
//Explanation:
//The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
//Input:
//org: [1], seqs: []
//Output:
//false

package Medium;
import java.util.*;

public class SequenceReconstruction {

	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		int idx[] = new int[org.length + 1];
        int pairs = org.length - 1;
        for (int i = 0; i < org.length; i++)
            idx[org[i]] = i;
        
        boolean seen[] = new boolean[org.length + 1];
        boolean isEmpty = true;
        for (List<Integer> seq : seqs)
        {
            for (int i = 0; i < seq.size(); i++)
            {
            	// If the seq list is not blank, make it false
                isEmpty = false;
                int curr = seq.get(i);
                if (curr < 1 || curr > org.length)
                    return false;
                
                if (i == 0) 
                    continue;
                
                // All the consecutive pairs should be visited 
                int prev = seq.get(i - 1);
                if (idx[prev] + 1 == idx[curr])
                {
                    if (!seen[prev]) 
                    {
                        seen[prev] = true;
                        pairs--;
                    }
                }
                // If its not consecutive, then prev should be less than curr
                else if (idx[prev] >= idx[curr])
                    return false;
            }
        }
        
        // If we have input, but the seq list is empty, 
        return pairs == 0 && !isEmpty;
    }
	
	public static void main(String[] args) {
		int[] org = {1, 2, 3};
		List<List<Integer>> seqs = new ArrayList<>();
		List<Integer> s1 = Arrays.asList(1, 2);
		List<Integer> s2 = Arrays.asList(1, 3);
		List<Integer> s3 = Arrays.asList(2, 3);
		seqs.add(s1);
		seqs.add(s2);
		seqs.add(s3);
		SequenceReconstruction obj = new SequenceReconstruction();
		System.out.println(obj.sequenceReconstruction(org, seqs));
	}
}
