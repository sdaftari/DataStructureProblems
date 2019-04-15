//Example:
//
//Input: 
//["RandomPickWithWeight","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//Output: [null,0,1,1,1,0]
//Time: O(n) to init, O(logn) for one pick
//Space: O(n)

package Medium;
import java.util.Random;

public class RandomPickWithWeight {
	
	Random random;
    int[] wSums;
    
    public RandomPickWithWeight(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(wSums[mid] == idx)
                return mid;
            else if(wSums[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
