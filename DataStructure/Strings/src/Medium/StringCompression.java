//Example 1:
//Input:
//["a","a","b","b","c","c","c"]
//Output:
//Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//Explanation:
//"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
// In-place. Space: O(1)

package Medium;

public class StringCompression {
	
	public int compress(char[] chars) 
	{
        int indexAns = 0, index = 0;
        while (index < chars.length)
        {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar)
            {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1)
            {
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
            }
        }
        
        return indexAns;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
