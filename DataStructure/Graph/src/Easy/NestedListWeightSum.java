//Example 2:
//
//Input: [1,[4,[6]]]
//Output: 27 
//Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

package Easy;
import java.util.*;

public class NestedListWeightSum {
	
//	public interface NestedInteger {
//		      // Constructor initializes an empty nested list.
//		      public NestedInteger();
//		 
//		      // Constructor initializes a single integer.
//		      public NestedInteger(int value);
//		 
//		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
//		      public boolean isInteger();
//		 
//		      // @return the single integer that this NestedInteger holds, if it holds a single integer
//		      // Return null if this NestedInteger holds a nested list
//		      public Integer getInteger();
//		 
//		      // Set this NestedInteger to hold a single integer.
//		      public void setInteger(int value);
//		 
//		      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//		      public void add(NestedInteger ni);
//		 
//		      // @return the nested list that this NestedInteger holds, if it holds a nested list
//		      // Return null if this NestedInteger holds a single integer
//		      public List<NestedInteger> getList();
//		  }
	
//	public int depthSum(List<NestedInteger> nestedList) {
//        if (nestedList == null)
//            return 0;
//        int level = 1;
//        int sum = 0;
//        
//        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
//        while(queue.size() > 0)
//        {
//            int size = queue.size();
//            for(int i = 0; i < size; i++)
//            {
//                NestedInteger ni = queue.poll();
//                if (ni.isInteger())
//                    sum += ni.getInteger() * level;
//                else
//                    queue.addAll(ni.getList());
//            }
//            level++;
//        }
//        
//        return sum;
//    }
	
	// Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., 
	// the leaf level integers have weight 1, and the root level integers have the largest weight.
//	public int depthSumInverse(List<NestedInteger> nestedList) {
//        int unweighted = 0, weighted = 0;
//        while (!nestedList.isEmpty())
//        {
//            List<NestedInteger> nextLevel = new ArrayList<>();
//            for (NestedInteger ni : nestedList)
//            {
//                // Since deeper the list, more weight will be given to single numbers at root.
//                // So in every iteration (equal to #lavels), this number will get added
//                if (ni.isInteger())
//                    unweighted += ni.getInteger();
//                else
//                   nextLevel.addAll(ni.getList()) ;
//            }
//            
//            weighted += unweighted;
//            nestedList = nextLevel;
//        }
//        
//        return weighted;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
