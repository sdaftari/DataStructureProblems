package Medium;

// Time: O(n)
public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater obj = new ContainerWithMostWater();
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(obj.maxArea(height));
	}

	public int maxArea(int[] height) 
	{
        int area = 0, i = 0, j = height.length - 1;
        
        while (i < j) 
        {
            int width = j - i;
            int ht = height[i] <= height[j] ? height[i++] : height[j--];
            int currArea = width * ht;
            
            if (currArea > area)
                area = currArea; 
        }
        
        return area;
    }
}
