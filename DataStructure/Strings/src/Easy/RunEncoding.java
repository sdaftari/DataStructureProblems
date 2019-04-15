package Easy;

public class RunEncoding {

	public static void main(String[] args) {
		String str = "AAAAAAAAAAAAABBCDDEEEEE";
		RunEncoding obj = new RunEncoding();
		System.out.println(obj.encoding(str.toCharArray()));
	}

	private String encoding(char[] str)
	{
		StringBuilder sb = new StringBuilder();
        int counter = 1;
        int i = 1; int j = 0;
        while (i < str.length)
        {
        	if (str[j] == str[i])
        		counter++;
        	else
        	{
        		sb.append(str[j]);
        		sb.append(counter);
                counter = 1;
        	}
        
        	j++; i++;
        }
        
        // *** IMP ***
        // append last character and its count
        sb.append(str[j]);
		sb.append(counter);
        return String.valueOf(sb);
	}
}
