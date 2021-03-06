// calculate sum. Maintain leftSum and rightSum. rightsum = total - a[i]
// if leftSum == rightsum, print the index
// Complexity O(n)

package Easy;

public class EquilibriumIndex {

	public static void main(String[] args) {
		EquilibriumIndex equi = new EquilibriumIndex();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equi.equilibrium(arr));
	}
	
	int equilibrium(int[] arr)
	{
		int total = 0;
		int leftSum = 0;
		for (int i : arr)
			total += i;
		
		for(int i = 0; i < arr.length-1; i++)
		{
			total -= arr[i];
			if (total == leftSum)
				return i;
			else
				leftSum += arr[i];
		}
		
		return -1;
	}
}
