package Medium;

public class CompareVersionNumbers {
	
	public int compareVersion(String version1, String version2) 
	{
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        // For each value, compare, if a greater value is found return it, else compare for value after period
        for (int i = 0; i < Math.max(v1.length, v2.length); i++)
        {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2)
                return -1;
            else if (num2 < num1)
                return 1;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
