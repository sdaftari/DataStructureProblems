//Given a boolean expression with following symbols.
//
//Symbols
//    'T' ---> true 
//    'F' ---> false 
//And following operators filled between symbols
//
//Operators
//    &   ---> boolean AND
//    |   ---> boolean OR
//    ^   ---> boolean XOR 
//Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
//
//Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
//
//Examples:
//
//Input: symbol[]    = {T, F, T}
//       operator[]  = {^, &}
//Output: 2
//The given expression is "T ^ F & T", it evaluates true
//in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
//
//Input: symbol[]    = {T, F, F}
//       operator[]  = {^, |}
//Output: 2
//The given expression is "T ^ F | F", it evaluates true
//in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 
//
//Input: symbol[]    = {T, T, F, T}
//       operator[]  = {|, &, ^}
//Output: 4
//The given expression is "T | T & F ^ T", it evaluates true
//in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
//and (T|((T&F)^T)). 

//Time Complexity: O(n3)
//Auxiliary Space: O(n2)

package Hard;

public class BooleanParenthesization {
	// Returns count of all possible parenthesizations that lead to result true for a boolean expression 
    // with symbols like true and false and operators like &, | and ^ filled between symbols
    static int countParenth(char symb[], char oper[], int n)     
    { 
        int F[][] = new int[n][n]; 
        int T[][] = new int[n][n]; 
  
        // Fill diagonal entries first. 
        // All diagonal entries in T[i][i] are 1 if symbol[i] is T (true). 
        // Similarly, all F[i][i] entries are 1 if symbol[i] is F (False) 
        for (int i = 0; i < n; i++)  
        { 
            F[i][i] = (symb[i] == 'F') ? 1 : 0; 
            T[i][i] = (symb[i] == 'T') ? 1 : 0; 
        } 
  
        // Now fill T[i][i+1], T[i][i+2], T[i][i+3]... in order And F[i][i+1], F[i][i+2], F[i][i+3]... in order 
        for (int len = 1; len < n; len++) 
        { 
            for (int i = 0, j = len; j < n; i++, j++)  
            { 
                T[i][j] = F[i][j] = 0; 
                for (int k = i; k < j; k++)  
                { 
                    // Find place of parenthesization using current value of len 
//                    int k = i + g; 
  
                    // Store Total[i][k] and Total[k+1][j] 
                	// Total permutations possible for string i to k will be True i to k + false i to k
                    int tik = T[i][k] + F[i][k]; 
                    int tkj = T[k + 1][j] + F[k + 1][j]; 
  
                    // Follow the recursive formulas  
                    // according to the current operator 
                    if (oper[k] == '&')  
                    { 
                    	// For & both substrings should be true
                        T[i][j] += T[i][k] * T[k + 1][j]; 
                        // So #false substrings = total (tik * tkj) - true substrings (T[i][k] * T[k + 1][j])
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]); 
                    } 
                    // If oper is OR, then result will be false only if both strings are false
                    if (oper[k] == '|')  
                    { 
                        F[i][j] += F[i][k] * F[k + 1][j]; 
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]); 
                    } 
                    // If oper is XOR, result will be true when only one of the substrings is false
                    // and res will false for both substrings true or both substrings false
                    if (oper[k] == '^') 
                    { 
                        T[i][j] += F[i][k] * T[k + 1][j] +  T[i][k] * F[k + 1][j]; 
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j]; 
                    } 
                } 
            } 
        } 
        return T[0][n - 1]; 
    } 

	public static void main(String[] args) {
		char symbols[] = "TTFT".toCharArray(); 
        char operators[] = "|&^".toCharArray(); 
        int n = symbols.length; 
  
        // There are 4 ways 
        // ((T|T)&(F^T)), (T|(T&(F^T))),  
        // (((T|T)&F)^T) and (T|((T&F)^T)) 
        System.out.println(countParenth(symbols, operators, n)); 

	}

}
