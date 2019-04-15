package Hard;

public class RegularExpressionMatch {
	
	public boolean isMatch(String s, String p) 
	{
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean T[][] = new boolean[text.length+1][pattern.length+1];
		
		T[0][0] = true;
		
		//Deals with patterns like a* or a*b* or a*b*c*, since * can be zero or more
		for (int i = 1; i < T[0].length; i++)
		{
			if (pattern[i-1] == '*')
				T[0][i] = T[0][i-2];
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
					// if two steps back, pattern is . or 
					// char before * is matching current character
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
		// TODO Auto-generated method stub

	}

}
