// Time: O(n^2) Space: O(n^2)

package Medium;

public class RegularExpressionMatch {
	
	public boolean isMatch(String s, String p) 
	{
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean T[][] = new boolean[text.length+1][pattern.length+1];
		
		T[0][0] = true;
		
		//Deals with patterns like a* or a*b* or a*b*c*, since * can be zero or more
		for (int j = 1; j < T[0].length; j++)
		{
			if (pattern[j-1] == '*')
				T[0][j] = T[0][j-2];
		}
		
		for (int i = 1; i < T.length; i++)
		{
			for (int j = 1; j < T[0].length; j++)
			{
				// '.' is any single character
				if (pattern[j-1] == '.' || pattern[j - 1] == text[i - 1])
					T[i][j] = T[i-1][j-1];
				else if (pattern[j-1] == '*')
				{
					T[i][j] = T[i][j-2];
					// if two steps back, pattern is . or so go back one row
					// char before * is matching current character take value from current cell
					if (pattern[j-2] == '.' || pattern[j-2] == text[i-1])
						T[i][j] = T[i][j] || T[i - 1][j];
				}
				else
					T[i][j] = false;
			}
		}
		
		return T[text.length][pattern.length];
    }

	public static void main(String[] args) {
		String s = "mississippi";
		String p = "mis*is*p*.";
		RegularExpressionMatch obj = new RegularExpressionMatch();
		System.out.println(obj.isMatch(s, p));
	}

}
