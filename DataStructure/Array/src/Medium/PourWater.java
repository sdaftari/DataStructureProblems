// Time: O(V*L)

package Medium;

public class PourWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] pourWater(int[] heights, int V, int K) 
    {
        for(int i = 0; i < V; i++) 
        {
            int cur = K;
            // Move left
            while(cur > 0 && heights[cur] >= heights[cur - 1]) 
                cur--;
            
            // Move right
            while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) 
                cur++;
            
            // Move left to K
            // If you have [3,3,1,1,1], V = 1 and K = 1, after "Move right", the droplet would be placed at 'cur' = 4
            // and "Move left to K" would be needed to adjust 'cur' back to 2, which is the correct place.
            while(cur > K && heights[cur] >= heights[cur - 1]) 
                cur--;
            
            heights[cur]++;
        }

        return heights;
    }
}
