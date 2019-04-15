//Example 2:
//Input: "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
//Example 5:
//Input: "/a/../../b/../c//.//"
//Output: "/c"

package Medium;
import java.util.*;

public class SimplifyPath {
	public String simplifyPath(String path) {
		// Need to use Dequeue. Since when we encounter '..', we will have to pop the last character like stack
		// But to print it we have to follow the FIFO structure. SO need to use dequeue
		// We can use stack and then in concatenation operation, use pop() instead of just iterating over
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String str : path.split("/"))
        {
        	// If .. is encountered, move to upper directory so pop the contents
            if (str.equals("..") && !stack.isEmpty())   
                stack.pop();
            // Otherwise if its not .. or . or blank, push it on to the stack
            else if (!set.contains(str))
                stack.push(str);
        }
        
        String res = "";
        // It will pop from bottom, instead of top
        for (String str1 : stack)
            res = "/" + str1 + res;
        return res.isEmpty() ? "/" : res;
    }

	public static void main(String[] args) {
		String s = "/a/../../b/../c//.//";
		SimplifyPath obj = new SimplifyPath();
		System.out.println(obj.simplifyPath(s));
	}

}
